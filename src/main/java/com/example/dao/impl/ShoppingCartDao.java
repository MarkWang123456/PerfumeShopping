package com.example.dao.impl;

import com.example.domain.ShoppingCartBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCartBean, Integer> {

}
