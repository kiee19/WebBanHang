package com.PS11390_NguyenTungNhatLinh_ASM.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderDetailEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@Component
public class OrderDetailConverter {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductConverter productConverter;
	
	@Autowired
	OrderService orderService;
	
	public CartDetailDTO toDTO(OrderDetailEntity entity) {
		CartDetailDTO dto = new CartDetailDTO();
		dto.setImgUrl(entity.getProductId().getImgUrl());
		dto.setProductName(entity.getProductId().getName());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		dto.setOrderId(entity.getOrderId().getId());
		dto.setProductId(entity.getProductId().getId());
		dto.setProductCode(entity.getProductId().getCode());
		return dto;
	}
	
	public OrderDetailEntity toEntity(CartDetailDTO dto) {
		OrderDetailEntity entity = new OrderDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		ProductDTO productDTO = productService.findById(dto.getProductId());
		entity.setProductId(productConverter.toEntity(productDTO));
		OrderEntity orderEntity = orderService.findById(dto.getOrderId());
		entity.setOrderId(orderEntity);
		return entity;
	}
}
