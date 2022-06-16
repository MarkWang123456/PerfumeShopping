package com.example.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.CommodityBean;


@Repository
public interface CommodityDao extends JpaRepository<CommodityBean, Integer> {
	
	CommodityBean findByIdCommodity(Integer idCommodity);
	
	default void deleteByIdCommodity(Integer IdCommodity) {
		
		
	}
}
