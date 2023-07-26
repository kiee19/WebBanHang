package com.PS11390_NguyenTungNhatLinh_ASM.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO extends AbtractDTO<ProductDTO>{
	
	@NotBlank(message = "not null")
	private String name;
	private String code;
	private Double price;
	private Integer quantity;
	private String imgUrl;
	private String description;
	private String status;
	private Boolean isDeleted;
	private String categoryCode;
	
}
