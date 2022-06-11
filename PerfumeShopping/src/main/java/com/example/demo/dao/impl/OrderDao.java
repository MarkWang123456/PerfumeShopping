package com.example.demo.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.OrderBean;

public interface OrderDao extends JpaRepository<OrderBean, Integer> {

}
