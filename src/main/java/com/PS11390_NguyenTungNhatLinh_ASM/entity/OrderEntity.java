package com.PS11390_NguyenTungNhatLinh_ASM.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="orders")
public class OrderEntity extends BaseEntity{
	
	@NotNull
	@Column(name="totalprice")
	private Double totalPrice;
	
	@NotNull
	@Column(name="address")
	private String address;
	
	@NotNull
	@Column(name="phone")
	private String phone;
	
	@NotNull
	@Column(name="status")
	private String status;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userid")
	private UserEntity userId;
	
	@OneToMany(mappedBy = "orderid")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();
}
