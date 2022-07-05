package com.example.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Commodity;
import com.example.domain.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	Role findByName(String name);
	 
	}
