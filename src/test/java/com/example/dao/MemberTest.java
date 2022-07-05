package com.example.dao;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.Optional;

import javax.annotation.Resource;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class MemberTest {
	
	@Resource
    private MemberDao memberDao;

	@Resource
	private OrderDao orderDao;
	
	@Test  //增加會員
	@Rollback(false)
	public void testSave() {
		Member expect=new Member();
		expect.setName("Mark");
		expect.setEmail("a0912753024@gmail.com");
		expect.setPhone("0912753024");
		expect.setSex("male");
		expect.setAddress("高雄");
		expect.setPassword("123");
		this.memberDao.save(expect);
		
		
//		Optional<Member> optional=memberDao.findById(10L);
//		if(optional.isPresent()) {
//			Member actual= optional.get();
//			Assertions.assertEquals(expect, actual);
//		}
	}
	
//	@Test //修改會員資料
//	public void testUpdate() {
//		Optional<Member> optionalExpect=memberDao.findById(1L);
//
//		if(optionalExpect.isPresent()) {
//			Member expect= optionalExpect.get();
//			expect.setName("mmark");
//			this.memberDao.save(expect);
//			
//			Optional<Member> optionalActual=memberDao.findById(1L);
//			if(optionalActual.isPresent()) {
//				Member actual= optionalActual.get();
//				Assertions.assertEquals(expect, actual);
//				System.out.println(actual);
//		}	
//		}		
//	}
		
	
//	@Test
//	public void testfindbyID() {
//		Optional<MemberBean> findidOptional=dao.findById(3);
//		
//			System.out.println(findidOptional);
//		}
	
//	@Test
//	public void testfindone() {
//		MemberBean bean=dao.findByIdMember(3);
//		
//		System.out.println(bean);
//	}
	
//	@Test
//	public void testUpdate() {
//		Member bean=dao.findByIdMember(3);
//		bean.setEmail("a0912753024@gmail.com");
//		dao.save(bean);
//		System.out.println(bean);
//	}
	
	
}
	
	

