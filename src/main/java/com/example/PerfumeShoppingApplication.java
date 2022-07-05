package com.example;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.dao.impl.MemberDao;
import com.example.domain.Member;
import com.example.domain.Role;
import com.example.service.MemberService;
import com.example.service.MemberServiceImpl;

@SpringBootApplication
public class PerfumeShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumeShoppingApplication.class, args);
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
