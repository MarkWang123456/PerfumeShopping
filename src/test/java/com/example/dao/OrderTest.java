package com.example.dao;

import javax.annotation.Resource;

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
public class OrderTest {

		@Resource
	    private OrderDao dao;
		
		@Resource
		private MemberDao memberDao;

//		@Test
//		public void testSave() {
//			OrderBean orderBean=new OrderBean();
//			orderBean.setPhone("0912753024");
//			this.dao.save(orderBean);
//
//		}
//
//
//		@Test
//		public void testOnetoManySave() {
//			OrderBean orderBean = new OrderBean();
//			orderBean.setAddress("楠梓區");
//			orderBean.setPhone("0912753024");
//
//			MemberBean memberBean = new MemberBean();
//	        memberBean.setName("MMM");
//	        memberBean.setEmail("getter3652097@gmail.com");
//
//	        memberDao.save(memberBean);
//	        dao.save(orderBean);
//		}
		
		@Test
		public void testfindone() {
			Order bean=dao.findByIdOrder(18);
			System.out.println(bean);
		}

		@Test
		public void testDeleteById(){
			dao.deleteByIdOrder(1);
		}



		
	}
