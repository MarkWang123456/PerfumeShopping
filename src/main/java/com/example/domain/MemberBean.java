package com.example.domain;

import java.util.Date;
import java.util.List;

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
	@Column(name = "IDMEMBER")
	private Integer idMember; 
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "GOOGLE")
	private String google;
	
	@Column(name = "FB")
	private String fb;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "SEX")
	private String sex;
	
	@Column(name = "BIRTH")
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "CREATIONTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@Column(name = "CHANGTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date changTime;
	
	
	@OneToMany(mappedBy = "memberBean" )
	private List<OrderBean> orderBeans;
	
}