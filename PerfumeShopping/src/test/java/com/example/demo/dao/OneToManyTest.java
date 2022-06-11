package com.example.demo.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.impl.MemberDao;
import com.example.demo.dao.impl.OrderDao;
import com.example.demo.domain.MemberBean;
import com.example.demo.domain.OrderBean;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class OneToManyTest {
	
	
	@Resource
    private MemberDao memberDao;
	
	@Resource
	private OrderDao orderDao;
	
	
	@Test
	public void testSave() {
		
		OrderBean orderBean=new OrderBean();
		orderBean.setAddress("楠梓區");
		orderBean.setPhone("0912753024");
		
		MemberBean memberBean=new MemberBean();
		memberBean.setName("MMM");
		memberBean.setEmail("getter3652097@gmail.com");
		
		
		
		memberBean.setOrderBeans(new ArrayList<OrderBean>());
		memberBean.getOrderBeans().add(orderBean);
		orderBean.setMemberBean(memberBean);
		 	
		//memberDao.findOne(memberBean.setMbid(1));
		//存好資料 用斷言 去比對//
		memberDao.save(memberBean);
		orderDao.save(orderBean);
		
	}
}
