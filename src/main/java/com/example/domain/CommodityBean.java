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
@Table(name = "commodity")
public class CommodityBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCOMMODITY")
	private Integer idCommodity; 
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "TONALITY")
	private String tonality;
	
	@Column(name = "SPECIFICATION")
	private String specification;
	
	@Column(name = "PRICE")
	private Integer price;
	
	@Column(name = "SALESVOLUME")
	private String salesVolume;
	
	@Column(name = "INVENTORY")
	private Integer inventory;
	
	@Column(name = "TOPNOTE")
	private String topnote;
	
	@Column(name = "MIDDLENOTE")
	private String middlenote;
	
	@Column(name = "BASENOTE")
	private String basenote;
	
	@Column(name = "LISTINGSTARTTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date listingStartTime;
	
	@Column(name = "TAKEDOWNTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date takeDownTime;
	
	@Column(name = "DISCOUNTID")
	private Integer discountid;
	
	@Column(name = "INTRODUCE")
	private String introduce;
}