package com.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "t_member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotNull
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
	private LocalDate birth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "creation_time")
	private LocalDate creationTime;
	
	@Column(name = "change_time")
	private LocalDate changeTime;
	
	
	@OneToMany(mappedBy = "member" )
	private List<Order> orders;

	@OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
	private List<ShoppingCart> shoppingCarts;

	public Member() {
		this.orders = new ArrayList<>();
		this.shoppingCarts = new ArrayList<>();
	}
}