package com.PS11390_NguyenTungNhatLinh_ASM.service;

import java.util.List;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;

public interface OrderDetailService {
	CartDetailDTO save(CartDetailDTO dto);
	List<CartDetailDTO> findByOrderId(Long id);
}
