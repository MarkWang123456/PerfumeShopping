package com.example.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Optional;

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
import com.example.dao.impl.ShoppingCartDao;
import com.example.domain.Commodity;
import com.example.domain.Member;
import com.example.domain.Order;
import com.example.domain.ShoppingCart;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
@ActiveProfiles   //
public class CommodityTest {
	
	@Resource
	private CommodityDao commodityDao;
	
	@Resource
	private OrderDao orderDao;
	
	@Resource
	private ShoppingCartDao shoppingCartDao;
	
//	@Test
//	@Rollback(false)
//	public void testSave() {
//		Commodity commodityBean=new Commodity();
//		commodityBean.setName("蒂芬妮香水");
//		commodityBean.setBrand("蒂芬妮");
//		commodityBean.setCategory("男香");
//		commodityBean.setPrice(700);
//
//		commodityDao.save(commodityBean);
//	}
//
//	@Test //新增商品
//	public void testAdd() {
//		CommodityBean commodityBean=commodityDao.findByIdCommodity(12);
//		System.out.println(commodityBean.getName());
//		List<OrderBean> orderBeans=commodityBean.getOrderBeans();
//		System.out.println(orderBeans);
//	}
	
	
//	@Test  //用ID查詢商品
//	public void testFindById() {
//		System.out.println(commodityDao.findById(1L).get());
//		
//	}
	
//	@Test 
//	@Rollback(false)  //修改商品
//	public void testUpdateCommodity() {
//		Commodity expected= commodityDao.findById(1L).get();
//		expected.setPrice(9999);
//		commodityDao.save(expected);		
//	}
	
	@Test  //刪除商品
	@Rollback(false)
	public void testDeleteById() {
		Commodity commodity= commodityDao.findById(3L).get(); //用id找出要刪的商品
//		List<Order> orders=orderDao.findAllByCommodities(commodity);  //用Commodities找出所有與要刪的商品Id有關連的order
//		List<ShoppingCart> shoppingCarts=shoppingCartDao.findAllByCommodities(commodity);//用Commodities找出所有與要刪的商品Id有關連的shoppingCart
//		
//		System.out.println(orders.size());
//		for(int i=0; i<orders.size(); i++){
//			orders.get(i).getCommodities().remove(commodity);
//		}
//		System.out.println(shoppingCarts.size());
//		for(int i=0; i<shoppingCarts.size(); i++){
//			shoppingCarts.get(i).getCommodities().remove(commodity);
//		}
		
		commodityDao.deleteById(3L);
	}
	
//	@Test //商品名稱查詢//
//	public void testFindByName() {
//		System.out.println(commodityDao.findByName("蒂芬妮香水"));
//	}
	
	
//	@Test //查訂單買了多少數量//
//	public void testFindBuyHowManyByCommodity() {
//		Integer purchaseNumber=orderDao.findById(3L).get().getPurchaseNumber();
//		System.out.println(purchaseNumber);
//	}

	
}
