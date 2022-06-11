package com.example.demo.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.ShoppingCartBean;

public interface ShoppingCartDAO extends JpaRepository<ShoppingCartBean, Integer> {

}
