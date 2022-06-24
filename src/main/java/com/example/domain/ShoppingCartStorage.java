package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


import lombok.Data;
import lombok.ToString;



@Entity
@Data
@ToString(exclude= {"shoppingCart","commodity"})
@Table(name="t_shoppingcart_commodity")
public class ShoppingCartStorage implements Serializable {
	
	@EmbeddedId
	private ShoppingCartStorageId id;
	
	@Column(name="number")
	private Integer number ;
	
	@ManyToOne
	@JoinColumn(name= "id_shoppingcart ")
	@MapsId("id_shoppingcart")
	private ShoppingCart shoppingCart;
	
	
	@ManyToOne
	@MapsId("id_commodity ")
	@JoinColumn(name = "id_commodity ")
	private Commodity commodity;

}
