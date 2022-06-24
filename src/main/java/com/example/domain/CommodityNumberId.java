package com.example.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;


@Embeddable
@Data
public class CommodityNumberId implements Serializable {  //生成中介表的複合鍵
	@Column(name = "id_shoppingcart")
	private Long shoppingcartId;

	@Column(name = "id_commodity")
	private Long commodityId;
	
	public CommodityNumberId(){
		
	}
	
	public CommodityNumberId(Long shoppingcartId, Long commodityId){
		this.shoppingcartId = shoppingcartId;
		this.commodityId = commodityId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(shoppingcartId, commodityId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommodityNumberId other = (CommodityNumberId) obj;
		return Objects.equals(shoppingcartId, other.shoppingcartId) && Objects.equals(commodityId, other.commodityId);
	}
	
}
