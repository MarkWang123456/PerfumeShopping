package com.example.demo.domain;

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
@Table(name = "MEMBER")
public class MemberBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Member_Id")
	private Integer Member_Id; 
	
	@Column(name = "Member_Name")
	private String Member_Name;
	
	@Column(name = "Member_Email")
	private String Member_Email;
	
	@Column(name = "Member_Google")
	private String Member_Google;
	
	@Column(name = "Member_Fb")
	private String Member_Fb;
	
	@Column(name = "Member_Phone")
	private String Member_Phone;
	
	@Column(name = "Member_Sex")
	private String Member_Sex;
	
	@Column(name = "Member_birth")
	@Temporal(TemporalType.DATE)
	private java.util.Date Member_birth;
	
	@Column(name = "Member_Address")
	private String Member_Address;
	
	@Column(name = "Member_Password")
	private String Member_Password;
	
	@Column(name = "Member_CreationTime")
	private java.util.Date Member_CreationTime;
	
	@Column(name = "Member_ChangTime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date Member_ChangTime;
	
	
}