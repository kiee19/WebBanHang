package com.PS11390_NguyenTungNhatLinh_ASM.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDTO implements Serializable{

	private static final long serialVersionUID = -2973026073108520009L;
	
	private Long productId;
	private Long orderId;
	private Integer quantity;
	private Double price;
	private String productName;
	private String productCode;
	private String imgUrl;
}
