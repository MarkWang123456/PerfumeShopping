package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Data
@Table(name = "ShoppingCart")
public class ShoppingCartBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ShoppingCart_Id")
	private Integer ShoppingCart_Id; 
	
	@Column(name = "Commodity_Id")
	private Integer Commodity_Id;	
	
	@Column(name = "Commodity_number")
	private Integer Commodity_number;
	
	@Column(name = "ShoppingCart_UpdateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ShoppingCart_UpdateTime;
}
