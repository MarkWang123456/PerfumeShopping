package com.example.demo.domain;

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
@Table(name = "ORDER")
public class OrderBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderid;
	
	@Column(insertable=false,updatable=false)
	private Integer mbid;	
	
	@Column(name = "promocodeid")
	private Integer promocodeid;
	
	@Column(name = "fulldeliveryid")
	private Integer fulldeliveryid;
	
	@Column(name = "payornot")
	private boolean payornot;
	
	@Column(name = "paytime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paytime;
	
	@Column(name = "shippingornot")
	private boolean shippingornot;
	
	@Column(name = "shippingtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippingtime;
	
	@Column(name = "receiptornot")
	private boolean receiptornot;
	
	@Column(name = "receipttime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date receipttime;
	
	@Column(name = "deliverynumber")
	private String deliveryNumber;
	
	@Column(name = "ordertime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //同時增加兩者
	@JoinColumn(name = "mbid")
	private MemberBean memberBean;
	
}
