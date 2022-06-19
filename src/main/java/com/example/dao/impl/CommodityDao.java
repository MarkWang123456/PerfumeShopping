package com.example.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Commodity;


@Repository
public interface CommodityDao extends JpaRepository<Commodity, Integer> {
	
	Commodity findByIdCommodity(Integer idCommodity);
	
	default void deleteByIdCommodity(Integer IdCommodity) {
		
		
	}
}
