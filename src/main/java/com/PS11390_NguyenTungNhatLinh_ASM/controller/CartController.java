package com.PS11390_NguyenTungNhatLinh_ASM.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/cart")
	public String viewCart(Model model) {
		CartDTO currentCart = (CartDTO) session.getAttribute("currentCart");
		if(ObjectUtils.isEmpty(currentCart)) {
			session.setAttribute("currentCart", new CartDTO());
		}
		HashMap<Long, CartDetailDTO> listDetail = currentCart.getListDetail();
		for(CartDetailDTO item : listDetail.values()) {
			System.out.println(item.getProductName());
		}

		return "viewsofweb/cart";
	}
	
	@GetMapping("/checkout")
	public String checkOut() {
		return "viewsofweb/checkout";
	}
	
	@GetMapping("/update")
	public String doGetUpdateCart(
			@RequestParam("productId") Long productId,
			@RequestParam("quantity") Integer quantity,
			@RequestParam(name = "isUpdate", required = false) Boolean isUpdate,
			HttpSession session,
			Model model) {
		isUpdate = true;
		CartDTO currentCart = (CartDTO) session.getAttribute("currentCart");
		currentCart = cartService.updateCart(currentCart, productId, quantity, isUpdate);
		session.setAttribute("currentCart", currentCart);
		return "viewsofweb/cart";
	}
	
	
}
