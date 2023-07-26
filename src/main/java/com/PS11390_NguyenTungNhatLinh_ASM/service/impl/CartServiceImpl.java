package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CartService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderDetailService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailService orderDetailService;

	@Override
	public CartDTO updateCart(CartDTO cart, Long productId, Integer quantity, boolean isReplace) {
		ProductDTO productDTO = productService.findById(productId);
		if(cart == null) {
			cart = new CartDTO();
		}
		HashMap<Long, CartDetailDTO> listDetail = cart.getListDetail();
		//thêm mới
		if(!listDetail.containsKey(productId)) {
			CartDetailDTO cartDetail = new CartDetailDTO();
			quantity = 1;
			cartDetail.setProductName(productDTO.getName());
			cartDetail.setPrice(productDTO.getPrice());
			cartDetail.setProductId(productId);
			cartDetail.setQuantity(quantity);
			cartDetail.setImgUrl(productDTO.getImgUrl());
			cartDetail.setProductCode(productDTO.getCode());
			listDetail.put(productId, cartDetail);
		}else if(quantity > 0) { // cập nhật, nếu số lượng sp > 0 thì công thêm or replace
			if(isReplace) {
				listDetail.get(productId).setQuantity(quantity);
			}else {
				Integer oldQuantity = listDetail.get(productId).getQuantity();
				listDetail.get(productId).setQuantity(oldQuantity + quantity);
			}
		}else {
			listDetail.remove(productId);
		}
		cart.setTotalPrice(getTotalPrice(cart));
		
		return cart;
	}

	@Override
	public Double getTotalPrice(CartDTO cart) {
		HashMap<Long, CartDetailDTO> listDetail = cart.getListDetail();
		Double totalPrice = 0D;
		for(CartDetailDTO item : listDetail.values()) {
			totalPrice += item.getPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	
	@Transactional
	@Override
	public void insertCart(CartDTO cart, Long userId, String address, String phone) {
		cart.setUserId(userId);
		cart.setAddress(address);
		cart.setPhone(phone);
		cart = orderService.save(cart);
		for(CartDetailDTO item : cart.getListDetail().values()) {
			item.setOrderId(cart.getOrderIdReturn());
			item = orderDetailService.save(item);
			//update quantity in product
			ProductDTO productDTO =  productService.findById(item.getProductId());
			Integer newQuantity =  productDTO.getQuantity() - item.getQuantity();
			productService.updateQuantity(newQuantity, item.getProductId());
		}
	}
	
	
}
