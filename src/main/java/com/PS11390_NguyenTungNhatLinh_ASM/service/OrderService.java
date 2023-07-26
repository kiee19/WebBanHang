package com.PS11390_NguyenTungNhatLinh_ASM.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;

public interface OrderService {
	OrderEntity findById(Long id);
	CartDTO save(CartDTO cart);
	List<OrderEntity> findAll();
	void updateStatus(String status, Long id);
}
