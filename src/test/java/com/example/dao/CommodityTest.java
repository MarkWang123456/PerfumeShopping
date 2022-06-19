package com.example.dao;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.CommodityDao;
import com.example.dao.impl.OrderDao;
import com.example.domain.Commodity;
import com.example.domain.Order;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@ActiveProfiles   //
public class CommodityTest {
	
	@Resource
	private CommodityDao commodityDao;
	
	@Resource
	private OrderDao orderDao;
	
//	@Test
//	@Rollback(false)
//	public void testSave() {
//		Commodity commodityBean=new Commodity();
//		commodityBean.setName("蒂芬妮香水");
//		commodityBean.setBrand("蒂芬妮");
//		commodityBean.setCategory("女香");
//
//		Order orderBean1=new Order();
//		orderBean1.setAddress("台南市");
//		orderBean1.setPhone("0912199365");
//
//		Order orderBean2=new Order();
//		orderBean2.setAddress("台北市");
//		orderBean2.setPhone("0912199700");
//
//		commodityBean.getOrderBeans().add(orderBean1);
//		commodityBean.getOrderBeans().add(orderBean2);
//		orderBean1.getCommodityBeans().add(commodityBean);
//		orderBean2.getCommodityBeans().add(commodityBean);
//
//		orderDao.save(orderBean2);
//		orderDao.save(orderBean1);
//		commodityDao.save(commodityBean);
//
//	}
//
//	@Test
//	public void testFind() {
//		CommodityBean commodityBean=commodityDao.findByIdCommodity(12);
//		System.out.println(commodityBean.getName());
//		List<OrderBean> orderBeans=commodityBean.getOrderBeans();
//		System.out.println(orderBeans);
//	}
	
	
//	@Test
//	public void testdetete() {
//		commodityDao.deleteByIdCommodity(12);
//		
//	}
	
}
