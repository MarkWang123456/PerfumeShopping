package com.example.dao;

import javax.annotation.Resource;

import org.junit.Test;
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
public class RoleTest {
//	
//	@Resource
//	private RoleDao roleDao;
//	
//	@Resource
//	private MemberDao memberDao;
//	
//	@org.junit.jupiter.api.Test
//	@Rollback(false)
//	public void testAddOrderAndMember() {
//		Role role=roleDao.findById(3L).get();
//		
//		Member member=memberDao.findById(7L).get();
//		
//		role.getMembers().add(member);
//		member.getRoles().add(role);
//		
//	
//		
//	}
}
