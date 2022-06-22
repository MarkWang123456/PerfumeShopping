package com.example.dao;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.MemberDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Commodity;
import com.example.domain.Member;
import com.example.domain.Order;


@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class OrderTest {

		@Resource
	    private OrderDao orderDao;
		
		@Resource
		private MemberDao memberDao;
		
		@Resource
		private CommodityDao commodityDao;


		@Test //新增訂單(同時加入會員及商品)
		@Rollback(false)
		public void testAddOrderAndMember() {
			Order order = new Order();
			order.setAddress("楠梓區");
			order.setPhone("0912753024");
			order.setPurchaseNumber(20);
			
			Optional<Member> member = memberDao.findById(2L);
			Optional<Commodity> commodity=commodityDao.findById(3L);
	        if(member.isPresent()) {        	
	        	
	        	order.setMember(member.get());
	        	commodity.get().getOrders().add(order);
	        	order.getCommodities().add(commodity.get());
 		
	    		orderDao.save(order);	
	    		commodityDao.save(commodity.get());        	
	        }        	              
		}
		
//		@Test
//		public void findById() {
//			Optional<Order> order=orderDao.findById(1L);	
//			System.out.println(order.get());
//		}
		
//		@Test //用Member查詢
//		public void testfindAllByMemberID() {
//			Member member=new Member();
//			member.setId(2L);
//			Optional<Member> source=memberDao.findById(2L);		
//			List<Order> expected=orderDao.findAllByMember(source.get());	
//			
//			List<Order> actual=orderDao.findAllByMember(member);
//					
//			Assertions.assertEquals(expected, actual);
//			System.out.println(expected);
//			System.out.println(actual);		
//		}
		
//		@Test //用電話查詢
//		public void testFindAllByPhone() {
//			List<Order> order=orderDao.findAllByPhone("0912753024");
//			System.out.println(order);
//		}
		
//		@Test  //刪除訂單用ID
//		@Rollback(false)
//		public void testDeleteById() {
//			orderDao.deleteById(3L);		
//		}
		
//		@Test  //用中介TABLE查詢訂單中的商品
//		public void testFindCommodityByOrder() {
//			List<Commodity> commodities=orderDao.findById(3L).get().getCommodities();
//			System.out.println(commodities);
//		}
		
		
//		@Test
//		@Rollback(false)
//		public void testAddCommodityAndUpdateOrder() {
//			Optional<Commodity> commodity=commodityDao.findById(1L);
//			if(orderDao.findById(1L).isPresent()) {
//	        	commodity.get().getOrders().add(orderDao.findById(1L).get());
//	        	orderDao.findById(1L).get().getCommodities().add(commodity.get());
//	        	commodityDao.save(commodity.get());
//			};
//			
//			
//		}
//		
		
//		@Test
//		
//		public void testSave() {
//			Commodity commodityBean=new Commodity();
//			commodityBean.setName("蒂芬妮香水");
//			commodityBean.setBrand("蒂芬妮");
//			commodityBean.setCategory("女香");
//			
//			Order orderBean1=new Order();
//			orderBean1.setAddress("台南市");
//			orderBean1.setPhone("0912199365");
//				
//			commodityBean.getOrders().add(orderBean1);	
//			orderBean1.getCommodities().add(commodityBean);
//			
//			orderDao.save(orderBean1);		
//			commodityDao.save(commodityBean);
//			
//		}




		
	}
