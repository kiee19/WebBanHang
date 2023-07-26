package com.PS11390_NguyenTungNhatLinh_ASM.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="category")
public class CategoryEntity extends BaseEntity{
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "code")
	private String code;
	
	@NotNull
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	@OneToMany(mappedBy = "categoryid")
	private List<ProductEntity> products = new ArrayList<>();
}
