package com.example.domain;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude= {"member"})
@Table(name = "t_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
//	@Column(name = "PROMOCODEID")
//	private Integer promocodeid;
	
//	@Column(name = "FULLDELIVERYID")
//	private Integer fulldeliveryid;
	
	@Column(name = "pay")
	private boolean pay;
	
	@Column(name = "pay_time")
	private LocalDate payTime;
	
	@Column(name = "shipping")
	private boolean shipping;
	
	@Column(name = "shipping_time")
	private LocalDate shippingTime;
	
	@Column(name = "receipt")
	private boolean receipt;
	
	@Column(name = "receipt_time")
	private LocalDate receiptTime;
	
	@Column(name = "delivery_number")
	private String deliveryNumber;
	
	@Column(name = "order_time")
	private LocalDate orderTime;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "id_member")
	private Member member;

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "t_order_commodity",joinColumns = @JoinColumn(name="id_order"),inverseJoinColumns = @JoinColumn(name="id_commodity"))
	private Set<Commodity> commodities = new HashSet<Commodity>();
	

}
