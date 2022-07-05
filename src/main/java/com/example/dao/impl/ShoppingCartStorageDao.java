package com.example.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.ShoppingCartStorage;
import com.example.domain.ShoppingCartStorageId;
import com.example.domain.ShoppingCart;

public interface ShoppingCartStorageDao extends JpaRepository<ShoppingCartStorage,ShoppingCartStorageId>{
	
	Set<ShoppingCartStorage> findByShoppingCart(ShoppingCart shoppingcart);
	
	
	
}
