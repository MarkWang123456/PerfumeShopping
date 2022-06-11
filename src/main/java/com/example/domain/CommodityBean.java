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
	@Column(name = "COMId")
	private Integer comid; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "tonality")
	private String tonality;
	
	@Column(name = "specification")
	private String specification;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "salesvolume")
	private String salesVolume;
	
	@Column(name = "inventory")
	private Integer inventory;
	
	@Column(name = "topnote")
	private String topnote;
	
	@Column(name = "middlenote")
	private String middlenote;
	
	@Column(name = "basenote")
	private String basenote;
	
	@Column(name = "listingstarttime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date listingstarttime;
	
	@Column(name = "takedowntime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date takedowntime;
	
	@Column(name = "discountid")
	private Integer discountid;
	
	@Column(name = "interduce")
	private String interduce;
}
