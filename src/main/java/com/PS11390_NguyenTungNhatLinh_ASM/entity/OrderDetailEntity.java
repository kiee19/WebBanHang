package com.PS11390_NguyenTungNhatLinh_ASM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_detail")
public class OrderDetailEntity extends BaseEntity{
	
	@NotNull
	@Column(name="quantity")
	private Integer quantity;
	
	@NotNull
	@Column(name="price")
	private Double price;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "productid")
	private ProductEntity productId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "orderid")
	private OrderEntity orderId;
	
}
