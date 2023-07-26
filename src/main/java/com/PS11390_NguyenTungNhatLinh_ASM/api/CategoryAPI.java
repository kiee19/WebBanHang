package com.PS11390_NguyenTungNhatLinh_ASM.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CategoryService;

@RestController
public class CategoryAPI {

	@Autowired
	CategoryService categoryService;

	@PostMapping("/api/category")
	public CategoryDTO create(@RequestBody CategoryDTO model) {
		return categoryService.save(model);
	}

	@PutMapping("/api/category")
	public CategoryDTO update(@RequestBody CategoryDTO model) {
		return categoryService.save(model);
	}

	@DeleteMapping("/api/category")
	public void delete(@RequestBody Long id) {
		categoryService.deleted(id);
	}
}
