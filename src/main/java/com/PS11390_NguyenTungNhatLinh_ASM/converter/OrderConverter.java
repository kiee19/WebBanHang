package com.PS11390_NguyenTungNhatLinh_ASM.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.UserEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.service.UserService;

@Component
public class OrderConverter {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserConverter userConverter;
	
	public CartDTO toDTO(OrderEntity entity) {
		CartDTO dto = new CartDTO();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getUserId().getId());
		return dto;
	}
	
	public OrderEntity toEntity(CartDTO dto) {
		OrderEntity entity = new OrderEntity();
		BeanUtils.copyProperties(dto, entity);
		UserEntity userEntity = userConverter.toEntity(userService.findById(dto.getUserId())); 
		entity.setUserId(userEntity);
		return entity;
	}
}
