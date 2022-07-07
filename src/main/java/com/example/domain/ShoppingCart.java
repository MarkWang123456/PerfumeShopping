package com.example.domain;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString(exclude= {"member"},doNotUseGetters = true)
@Table(name = "t_shoppingcart")

public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "number")
	private Integer number;
	
	@Column(name = "update_time")
	private LocalDate updateTime;

	@ManyToOne
	@JoinColumn(name = "id_member")
	private Member member;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_shoppingcart_commodity", joinColumns = @JoinColumn(name = "id_shoppingcart"), inverseJoinColumns = @JoinColumn(name = "id_commodity"))
	private Set<Commodity> commodities = new HashSet<>();
}
