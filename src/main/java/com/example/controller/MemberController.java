package com.example.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.domain.Member;
import com.example.domain.Role;
import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/PerfumeShopping")
@RestController
public class MemberController {
	private final MemberService memberService;
	
	@GetMapping("/members")
	public ResponseEntity<List<Member>>getMembers(){
		return ResponseEntity.ok().body(memberService.getMembers());
	}
	
	@PostMapping("/member/save")
	public ResponseEntity<Member>saveMember(@RequestBody Member member){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfumeShopping/member/save").toUriString());
		return ResponseEntity.created(uri).body(memberService.saveMember(member));
	}
	
	@PostMapping("/role/save")
	public ResponseEntity<Role>saveRole(@RequestBody Role role){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfumeShopping/role/save").toUriString());
		return ResponseEntity.created(uri).body(memberService.saveRole(role));
	}
	
	@PostMapping("/role/addtomember")
	public ResponseEntity<?>addRoleToMember(@RequestBody RoleToMemberForm form){
		memberService.addRoleToMember(form.getMembername(),form.getRolename());
		return ResponseEntity.ok().build(); 
	}
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request,HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token=authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm=Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier=JWT.require(algorithm).build();
				DecodedJWT decodedJWT=verifier.verify(refresh_token);
				String membername=decodedJWT.getSubject();
				Member member=memberService.getMember(membername);		
				String access_token =JWT.create()
						.withSubject(member.getName())  // 驗證的主题
						.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))  // 驗證过期的时间
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles",member.getRoles().stream().map(Role::getName).collect(Collectors.toList()))  // 驗證是有谁生成
						.sign(algorithm);
				Map<String, String> tokens =new HashMap<>();
				tokens.put("access_token", access_token);
				tokens.put("refresh_token", refresh_token);
				response.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
			} catch (Exception e) {			
				response.setHeader("error", e.getMessage());
				response.setStatus(HttpStatus.FORBIDDEN.value());
				//response.sendError(HttpStatus.FORBIDDEN.value());
				Map<String, String> error =new HashMap<>();
				error.put("error_token", e.getMessage());
				response.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		}else {
			throw new RuntimeException("Refresh token is missing");
		}
	} 
	}
	


@Data
class RoleToMemberForm {
	private String membername;
	private String rolename;
}
