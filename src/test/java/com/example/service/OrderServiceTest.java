package com.example.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Member;
import com.example.domain.Order;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {
	@Resource
	private OrderService orderService;
	
	@Resource
	private MemberDao memberDao;
	
	@Resource
	private OrderDao orderDao;

	
//	@Test
//	public void testUseMemberFindAllOrder() {
//		Set<Order> expected=orderService.useMemberFindAllOrder(memberDao.findById(2L).get());
//		System.out.println(expected);
//		Set<Order> actual=orderDao.findAllByMember(memberDao.findById(2L).get());
//		Assertions.assertEquals(expected, actual);
//	}
	
	
	@Test
	public void testFindAllOrder() {
		Member member=new Member();
		member.setId(2L);
		List<Order> rrrOrders= orderService.useMemberFindAllOrder(member);
		System.out.println(rrrOrders);		
	}

	@Test
	public void testFindAll(){
		List<Order> result = orderService.findAll();

		for(Order order : result)
		System.out.println(order);
	}

	@Test
	public void testFindAllPaging(){
		List<Order> result = orderService.findAllPaging(0);

		for(Order order : result ){
			System.out.println(order);
		}
	}

	@Test
	public void testFindOrderPaging(){
		Member member = new Member();
		member.setId(1L);
		Integer page = 0;
		List<Order> result = orderService.findByMemberPaging(member, page).getContent();
		for(Order order:result){
			System.out.println(order);
		}
	}
}
