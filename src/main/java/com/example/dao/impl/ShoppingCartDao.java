package com.example.dao.impl;

import com.example.domain.Member;
import com.example.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {

	  
//
//    ShoppingCart findByMemberBean(Member memberBean);
//
//     void deleteByIdShoppingCart(Integer idShoppingCart);
//
//    ShoppingCart findByIdShoppingCart(Integer idShoppingCart);
}
