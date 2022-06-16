package com.example.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.print.attribute.standard.MediaSize.NA;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude= {"memberBean"})
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
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(name = "O_TABLE_COMMODITY",joinColumns = @JoinColumn(name="ID_ORDER"),inverseJoinColumns = @JoinColumn(name="ID_COMMODITY"))
	private List<CommodityBean> commodityBeans=new ArrayList<CommodityBean>();
	
	
}
