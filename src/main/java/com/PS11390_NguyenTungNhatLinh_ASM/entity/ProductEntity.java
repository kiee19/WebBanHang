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
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "code")
	private String code;
	
	@NotNull
	@Column(name = "price")
	private Double price;
	
	@NotNull
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "imgurl")
	private String imgUrl;
	
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name="status")
	private String status;
	
	@NotNull
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="categoryid")
	private CategoryEntity categoryId;
	
	@OneToMany(mappedBy = "productId")
	private List<OrderDetailEntity> orderDetails = new ArrayList<>();

}
