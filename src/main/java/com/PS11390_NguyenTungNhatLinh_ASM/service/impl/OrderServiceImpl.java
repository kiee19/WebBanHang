package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.PS11390_NguyenTungNhatLinh_ASM.converter.OrderConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.OrderRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderConverter orderConverter;

	@Override
	public CartDTO save(CartDTO cart) {
		OrderEntity entity = orderConverter.toEntity(cart);
		entity.setStatus("Chưa giao hàng");
		entity = orderRepository.saveAndFlush(entity);
		cart.setOrderIdReturn(entity.getId());
		return cart;
	}

	@Override
	public OrderEntity findById(Long id) {
		Optional<OrderEntity> entity = orderRepository.findById(id);
		return entity.isPresent() ? entity.get() : null;
	}

	@Override
	public List<OrderEntity> findAll() {
		List<OrderEntity> orders = orderRepository.findAll();  
		return orders;
	}

	@Override
	public void updateStatus(String status, Long id) {
		orderRepository.updateStatus(status, id);
	}
	
}
