package com.example.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.CommodityNumber;
import com.example.domain.CommodityNumberId;
import com.example.domain.ShoppingCart;

public interface CommodityNumberDao extends JpaRepository<CommodityNumber,CommodityNumberId>{
	
	List<CommodityNumber> findByShoppingCart(ShoppingCart shoppingcart);
	
}
