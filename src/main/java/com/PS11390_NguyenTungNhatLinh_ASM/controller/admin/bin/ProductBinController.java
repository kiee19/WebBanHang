package com.PS11390_NguyenTungNhatLinh_ASM.controller.admin.bin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CategoryService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@Controller
@RequestMapping("/admin/")
public class ProductBinController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/product-bin/list")
	public String list(Model model, @RequestParam(value ="page",required = false) Integer page, 
			@RequestParam(value= "limit",required = false) Integer limit) {
		Pageable pageable;
		if(page == null & limit == null) {
			page = 1;
			limit = 5;
			 pageable = PageRequest.of(0, limit);
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		int totalPage = (int) Math.ceil((double) (productService.totalItem())/ limit);
		List<ProductDTO> dto = productService.findByIsDeletedTrue(pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listproductbin";
	}
	
	@RequestMapping("/product-bin/search")
	public String search(Model model,@RequestParam("keyword") String keyword,  @RequestParam(value ="page",required = false) Integer page, 
			@RequestParam(value= "limit",required = false) Integer limit) {
		Pageable pageable;
		if(page == null & limit == null) {
			page = 1;
			limit = 5;
			 pageable = PageRequest.of(0, limit);
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		int totalPage = (int) Math.ceil((double) (productService.totalItem())/ limit);
		List<ProductDTO> dto = productService.findByIsDeletedTrueAndNameLike(keyword,pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listproductbin";
	}
	
	@RequestMapping(value = "product-bin/restore/{id}")
	public String delete(@PathVariable("id") Long id ,Model model) {
		productService.isDeleted(Boolean.FALSE, id);
		return "redirect:/admin/product-bin/list";
	}
}
