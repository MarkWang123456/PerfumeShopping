package com.example.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Order;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {
//	@Resource
//	private OrderService orderService;
//	
//	@Resource
//	private MemberDao memberDao;
//	
//	@Resource
//	private OrderDao orderDao;
//
//	
//	@Test
//	public void testUseMemberFindAllOrder() {
//		List<Order> expected=orderService.useMemberFindAllOrder(memberDao.findById(2L).get());
//		System.out.println(expected);
//		List<Order> actual=orderDao.findAllByMember(memberDao.findById(2L).get());
//		Assertions.assertEquals(expected, actual);
//	}
}
