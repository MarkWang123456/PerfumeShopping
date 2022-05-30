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
@Table(name = "Commodity")
public class CommodityBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Commodity_Id")
	private Integer Commodity_Id; 
	
	@Column(name = "Commodity_Name")
	private String Commodity_Name;
	
	@Column(name = "Commodity_Brand")
	private String Commodity_Brand;
	
	@Column(name = "Commodity_Category")
	private String Commodity_Category;
	
	@Column(name = "Commodity_Tonality")
	private String Commodity_Tonality;
	
	@Column(name = "Commodity_Specification")
	private String Commodity_Specification;
	
	@Column(name = "Commodity_Price")
	private Integer Commodity_Price;
	
	@Column(name = "Commodity_SalesVolume")
	private String Commodity_SalesVolume;
	
	@Column(name = "Commodity_Inventory")
	private String Commodity_Inventory;
	
	@Column(name = "Commodity_TopNote")
	private String Commodity_TopNote;
	
	@Column(name = "Commodity_MiddleNote")
	private String Commodity_MiddleNote;
	
	@Column(name = "Commodity_BaseNote")
	private String Commodity_BaseNote;
	
	@Column(name = "Commodity_ListingStartTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Commodity_ListingStartTime;
	
	@Column(name = "Commodity_TakedownTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Commodity_TakedownTime;
	
	@Column(name = "Commodity_Discount")
	private Integer Commodity_Discount;
	
	@Column(name = "Commodity_DiscountBeginTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Commodity_DiscountBeginTime;
	
	@Column(name = "Commodity_DiscountEndTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Commodity_DiscountEndTime;	
	
	@Column(name = "Commodity_Interduce")
	private String Commodity_Interduce;
}
