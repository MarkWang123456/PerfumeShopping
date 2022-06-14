package com.example.domain;

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
@Table(name = "SHOPPINGCART")
public class ShoppingCartBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDSHOPPINGCART")
	private Integer idShoppingCart; 
	
	@Column(name = "IdCOMMODITY")
	private Integer idCommodity;	
	
	@Column(name = "NUMBER")
	private Integer number;
	
	@Column(name = "UPDATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
}
