package com.example.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "O_TABLE")
public class OrderBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDORDER")
	private Integer idOrder;
	
	@Column(name = "PROMOCODEID")
	private Integer promocodeid;
	
	@Column(name = "FULLDELIVERYID")
	private Integer fulldeliveryid;
	
	@Column(name = "PAYORNOT")
	private boolean payornot;
	
	@Column(name = "PAYTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date payTime;
	
	@Column(name = "SHIPPINGORNOT")
	private boolean shippingOrNot;
	
	@Column(name = "SHIPPINGTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippingTime;
	
	@Column(name = "RECEIPTORNOT")
	private boolean receiptornot;
	
	@Column(name = "RECEIPTTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date receiptTime;
	
	@Column(name = "DELIVERYNUMBER")
	private String deliveryNumber;
	
	@Column(name = "ORDERTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "IDMEMBER")
	private MemberBean memberBean;
	
}
