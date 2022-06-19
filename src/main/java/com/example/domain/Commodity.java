package com.example.domain;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
//@ToString(exclude= {"orderBeans"})
@Table(name = "t_commodity")
public class Commodity {
	
	public Commodity(){
		this.orders = new HashSet<>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
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
	
	@Column(name = "sales_volume")
	private String salesVolume;
	
	@Column(name = "inventory")
	private Integer inventory;
	
	@Column(name = "top_note")
	private String topNote;
	
	@Column(name = "middle_note")
	private String middleNote;
	
	@Column(name = "base_note")
	private String baseNote;
	
	@Column(name = "listing_start_time")
	private LocalDate listingStartTime;
	
	@Column(name = "take_down_time")
	private LocalDate takeDownTime;
	
//	@Column(name = "discountid")
//	private Long discountid;
	
	@Column(name = "introduce")
	private String introduce;
	
	@ManyToMany(mappedBy = "commodities",fetch = FetchType.EAGER)
	private Set<Order> orders =new HashSet<Order>();

	@ManyToMany(mappedBy = "commodities", fetch = FetchType.EAGER)
	private Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>();
}
