package com.example.dao.impl;

import com.example.domain.Commodity;
import com.example.domain.Member;
import com.example.domain.Order;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
	
//  Order findByMember(Member member);
	
	List<Order> findByMember(Member member);
	
//	Set<Order> findAllByMember(Member member);
	
	Set<Order> findAllByPhone(String phone);
	
	Set<Order> findAllByCommodities(Commodity commodity);
	
	

//	void deleteByIdOrder(Integer idOrder);
}
