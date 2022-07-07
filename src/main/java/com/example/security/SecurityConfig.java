package com.example.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.filter.MemberAuthenticationFilter;
import com.example.filter.MemberAuthorizationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {  //建立一個 SecurityConfig 類別，作為安全設定時組態檔案
	//WebSecurityConfigurerAdapter 有三個重要的configure 可以覆寫，
	//一個與驗證相關的AuthenticationManagerBuilder，
	//另外兩個是與Web 相關的HttpSecurity 和WebSecurity。
	
	private final UserDetailsService userDetailsService;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	//AuthenticationManagerBuilder : 用來配置全局的驗證資訊，也就是AuthenticationProvider 和UserDetailsService。

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		MemberAuthenticationFilter memberAuthenticationFilter=new MemberAuthenticationFilter(authenticationManagerBean());
		memberAuthenticationFilter.setFilterProcessesUrl("/PerfumeShopping/login");
		http.csrf().disable();// 因為是做 token 驗證，不用開啟避免 csrf
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //無狀態的 session 政策，不使用 HTTPSession
		http.authorizeHttpRequests().antMatchers("/PerfumeShopping/login/**","/token/refresh/**").permitAll();
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/PerfumeShopping/member/**").hasAnyAuthority("ROLE_USER");
		http.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/PerfumeShopping/member/**").hasAnyAuthority("ROLE_ADMIN");
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/PerfumeShopping/member/save/**").hasAnyAuthority("ROLE_ADMIN");
		http.authorizeHttpRequests().anyRequest().permitAll();
		http.addFilter(memberAuthenticationFilter);
		http.addFilterBefore(new MemberAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
//	HttpSecurity : 用來配置各種具體的驗證機制規則，
//	如OpenIDLoginConfigurer、AnonymousConfigurer、FormLoginConfigurer、HttpBasicConfigurer 等。
	
	@Bean
	@Override       //AuthenticationManager是一個靜態類別，可管理應用程式所使用的驗證模組
	public AuthenticationManager authenticationManagerBean() throws Exception{ 
		return super.authenticationManagerBean();
	}

}
