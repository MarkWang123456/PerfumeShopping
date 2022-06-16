package com.example.dao.impl;

import com.example.domain.OrderBean;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderBean, Integer> {
	
	OrderBean findByIdOrder(Integer idOrder);
}
