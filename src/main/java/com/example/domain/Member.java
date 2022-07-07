package com.example.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;


@Entity
@EntityScan
@Data
@ToString(exclude= {"roles","orders"},doNotUseGetters = true)
@JsonIgnoreProperties(value={"orders","shoppingCarts"})
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
	private Set<Order> orders;

	@OneToMany(mappedBy = "member",cascade = CascadeType.PERSIST)
	private Set<ShoppingCart> shoppingCarts;

	public Member() {
		this.orders = new HashSet<>();
		this.shoppingCarts = new HashSet<>();
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="t_member_role", 
		joinColumns = {@JoinColumn(name="id_member")}, 
		inverseJoinColumns = {@JoinColumn(name="id_role")})
    private Collection<Role> roles= new ArrayList<>();
	

}