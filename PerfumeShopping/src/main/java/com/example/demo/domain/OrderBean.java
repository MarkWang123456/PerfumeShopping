package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ORDER")
public class OrderBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Order_Id")
	private Integer Order_Id;
	
	@Column(name = "Member_Id")
	private Integer Member_Id;	
	
	@Column(name = "PromoCode_Id")
	private Integer PromoCode_Id;
	
	@Column(name = "Order_PayOrNot")
	private boolean Order_PayOrNot;
	
	@Column(name = "Order_PayTime")
	private Date Order_PayTime;
	
	@Column(name = "Order_ShippingOrNot")
	private boolean Order_ShippingOrNot;
	
	@Column(name = "Order_ShippingTime")
	private Date Order_ShippingTime;
	
	@Column(name = "Order_ReceiptOrNot")
	private boolean Order_ReceiptOrNot;
	
	@Column(name = "Order_ReceiptTime")
	private Date Order_ReceiptTime;
	
	@Column(name = "Order_DeliveryNumber")
	private String Order_DeliveryNumber;
	
	@Column(name = "Order_OrderTime")
	private Date Order_OrderTime;
	
	@Column(name = "Order_Address")
	private String Order_Address;
	
	@Column(name = "Order_Phone")
	private String Order_Phone;
	
	
}
