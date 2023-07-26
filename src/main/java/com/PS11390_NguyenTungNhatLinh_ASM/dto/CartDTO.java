package com.PS11390_NguyenTungNhatLinh_ASM.dto;

import java.io.Serializable;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO implements Serializable{

	private static final long serialVersionUID = 7622439309996443644L;
	
	private Long userId;
	private String address;
	private String phone;
	HashMap<Long, CartDetailDTO> listDetail = new HashMap<>();
	private Double totalPrice = 0D;
	private String status;
	private Long orderIdReturn;
}
