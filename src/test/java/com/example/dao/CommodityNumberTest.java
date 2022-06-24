package com.example.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.impl.CommodityNumberDao;
import com.example.dao.impl.ShoppingCartDao;
import com.example.domain.CommodityNumber;
import com.example.domain.ShoppingCart;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class CommodityNumberTest {
	@Resource 
	private CommodityNumberDao commodityNumberDao;
	
	@Resource
	private ShoppingCartDao shoppingCartDao;
	
	@Test
	public void testfind() {
		ShoppingCart shopping=shoppingCartDao.findById(4L).get();
		List<CommodityNumber> aaa=commodityNumberDao.findByShoppingCart(shopping);
		System.out.println(aaa);
		}
	
}
