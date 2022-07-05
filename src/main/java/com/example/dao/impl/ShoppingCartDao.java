package com.example.dao.impl;

import com.example.domain.Commodity;
import com.example.domain.Member;
import com.example.domain.Order;
import com.example.domain.ShoppingCart;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {

	Set<ShoppingCart> findAllByCommodities(Commodity commodity);
	
	ShoppingCart findByMember(Member member);
	
	Set<ShoppingCart> findAllByMember(Member member);
//
//    ShoppingCart findByMemberBean(Member memberBean);
//
//     void deleteByIdShoppingCart(Integer idShoppingCart);
//
//    ShoppingCart findByIdShoppingCart(Integer idShoppingCart);
}
