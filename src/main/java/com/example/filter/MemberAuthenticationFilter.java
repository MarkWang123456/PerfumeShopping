package com.example.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager authenticationManager;
	
	public MemberAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
		String membername=request.getParameter("membername");
		String password=request.getParameter("password");
		log.info("用戶名是:{}",membername);
		log.info("密碼是:{}",password);
		UsernamePasswordAuthenticationToken authenticationTokennew=new UsernamePasswordAuthenticationToken(membername, password);
		return authenticationManager.authenticate(authenticationTokennew);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		User user=(User)authentication.getPrincipal();    //Principle是指一個存取系統資源的實體(Entity)，簡單來說就是登入的使用者。
		Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
		String access_token =JWT.create()
				.withSubject(user.getUsername())  // 驗證的主题
				.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))  // 驗證过期的时间
				.withIssuer(request.getRequestURI().toString())  //设置 载荷 签名是有谁生成 這個request是誰發的
				.withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))  // 自定义信息通过 withClaim 方法进行添加
				.sign(algorithm);
		String refresh_token =JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+30*60*1000))
				.withIssuer(request.getRequestURI().toString())
				.sign(algorithm);
		
//		response.setHeader("access_token", access_token);
//		response.setHeader("refresh_token", refresh_token);
		Map<String, String> tokens =new HashMap<>();
		tokens.put("access_token", access_token);
		tokens.put("refresh_token", refresh_token);
		response.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
		new ObjectMapper().writeValue(response.getOutputStream(), tokens);
	}
	
}
