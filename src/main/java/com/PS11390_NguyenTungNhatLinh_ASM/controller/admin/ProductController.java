package com.PS11390_NguyenTungNhatLinh_ASM.controller.admin;

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
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/product/list")
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
		List<ProductDTO> dto = productService.findByIsDeletedFalse(pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listproduct";
	}
	
	@RequestMapping("/product/edit")
	public String edit(@RequestParam(value="id", required = false) Long id ,Model model) {
		ProductDTO productDTO = new ProductDTO();
		if(id != null) {
			productDTO = productService.findById(id);
		}
		List<String> listCode = new ArrayList<>();
		List<CategoryDTO> categoryDTO = categoryService.findByIsDeletedFalse();
		for(CategoryDTO item : categoryDTO) {
			listCode.add(item.getCode());
		}
		
		List<String> listStatus = new ArrayList<>();
		listStatus.add("còn hàng");
		listStatus.add("hết hàng");
//		if(id != null) {
//			categoryDTO = productService.findById(id);
//		}
		model.addAttribute("listCategoryCode",listCode);
		model.addAttribute("listStatus",listStatus);
		model.addAttribute("model",productDTO);
		return "viewsofadmin/editproduct";
	}
	
	@RequestMapping("/product/search")
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
		List<ProductDTO> dto = productService.findByIsDeletedFalseAndNameLike(keyword,pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listproduct";
	}
	
	@RequestMapping(value = "product/delete/{id}")
	public String delete(@PathVariable("id") Long id ,Model model) {
		productService.isDeleted(Boolean.TRUE, id);
		return "redirect:/admin/product/list";
	}
}
