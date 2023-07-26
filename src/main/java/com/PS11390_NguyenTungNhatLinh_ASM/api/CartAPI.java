package com.PS11390_NguyenTungNhatLinh_ASM.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CartService;

@RestController
@RequestMapping("/api/cart/")
public class CartAPI {
	@Autowired
	CartService cartService;

	@GetMapping("update")
	public ResponseEntity<?> updateCart(@RequestParam("productId") Long productId,
			@RequestParam("quantity") Integer quantity, @RequestParam("isReplate") Boolean isReplate,
			HttpSession session) {
		CartDTO currentCart = (CartDTO) session.getAttribute("currentCart");
		currentCart = cartService.updateCart(currentCart, productId, quantity, isReplate);
		return ResponseEntity.ok(currentCart);
	}

	@GetMapping("checkout")
	public ResponseEntity<?> checkOut(@RequestParam("address") String address, @RequestParam("phone") String phone,
			HttpSession session) {
		CartDTO currentCart = (CartDTO) session.getAttribute("currentCart");
		UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
		cartService.insertCart(currentCart, currentUser.getId(), address, phone);
		session.setAttribute("currentCart", new CartDTO());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
