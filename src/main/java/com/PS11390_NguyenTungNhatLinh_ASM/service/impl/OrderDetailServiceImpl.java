package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS11390_NguyenTungNhatLinh_ASM.converter.OrderConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.converter.OrderDetailConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderDetailEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.OrderDetailRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderDetailService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	OrderDetailConverter orderDetailConverter;
	
	@Autowired
	OrderService orderService;

	@Override
	public CartDetailDTO save(CartDetailDTO dto) {
		OrderDetailEntity entity = orderDetailConverter.toEntity(dto);
		entity = orderDetailRepository.save(entity);
		return dto;
	}

	@Override
	public List<CartDetailDTO> findByOrderId(Long id) {
		OrderEntity order = orderService.findById(id);
		List<OrderDetailEntity> listOrder = orderDetailRepository.findByOrderId(order);
		List<CartDetailDTO> cartDetails = new ArrayList<>();
		for(OrderDetailEntity item : listOrder) {
			CartDetailDTO cartDetailDTO = orderDetailConverter.toDTO(item);
			cartDetails.add(cartDetailDTO);
		}
		return cartDetails;
	}
}
