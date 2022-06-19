package com.example.dao.impl;

import com.example.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
	
	Order findByIdOrder(Integer idOrder);

	void deleteByIdOrder(Integer idOrder);
}
