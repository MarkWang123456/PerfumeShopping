package com.example.demo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "MEMBER")
public class MemberBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MBid")
	private Integer mbid; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "google")
	private String google;
	
	@Column(name = "fb")
	private String fb;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "birth")
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "creationtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationtime;
	
	@Column(name = "changtime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date changtime;
	
	
	@OneToMany(mappedBy = "memberBean" )
	private List<OrderBean> orderBeans;
	
}