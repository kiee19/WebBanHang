package com.PS11390_NguyenTungNhatLinh_ASM.api;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@RestController
public class ProductAPI {

	@Autowired
	ProductService productService;
	
	@ResponseBody
	@PostMapping("/api/product")
	public ResponseEntity<?> create(@RequestBody @Validated ProductDTO model, BindingResult bindingResult) {
		ProductDTO dto = productService.save(model);
		if(bindingResult.hasErrors()) {
			return new ResponseEntity(dto, HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(dto);
	}

	@PutMapping("/api/product")
	public ProductDTO update(@RequestBody ProductDTO model) {
		return productService.save(model);
	}

	@DeleteMapping("/api/product")
	public void delete(@RequestBody Long id) {
		productService.deleted(id);
	}
}
