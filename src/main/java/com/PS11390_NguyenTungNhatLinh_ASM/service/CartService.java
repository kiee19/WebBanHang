package com.PS11390_NguyenTungNhatLinh_ASM.service;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;

public interface CartService {
	CartDTO updateCart(CartDTO cart, Long productId, Integer quantity, boolean isReplace);
	Double getTotalPrice(CartDTO cart);
	void insertCart(CartDTO cart, Long userId, String address, String phone);
}
