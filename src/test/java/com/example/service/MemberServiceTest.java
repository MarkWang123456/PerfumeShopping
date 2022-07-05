package com.example.service;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.RoleDao;
import com.example.domain.Member;
import com.example.domain.Role;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class MemberServiceTest {
	@Resource
	private MemberDao memberDao;
	
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private MemberServiceImpl memberServiceImpl;
	
//	@Test
//	@Rollback(false)
//	public void test() {
//		Member member=new Member();
//		member.setName("大中天");
//		member.setPassword("12345");	
//		memberServiceImpl.saveMember(member);	
//	}
	
	
	@Test
	@Rollback(false)
	public void test() {
		
		memberServiceImpl.addRoleToMember("大中天", "ROLE_USER");
	}
	
	
	
}
