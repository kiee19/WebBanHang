package com.PS11390_NguyenTungNhatLinh_ASM.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CategoryService;

@Controller
@RequestMapping("/admin/")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "category/list")
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
		int totalPage = (int) Math.ceil((double) (categoryService.totalItem())/ limit);
		System.out.println(categoryService.totalItem());
		List<CategoryDTO> categoryDTO = categoryService.findByIsDeletedFalse(pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("list", categoryDTO);
		return "viewsofadmin/listcategory";
	}
	
	@RequestMapping(value = "category/edit")
	public String edit(@RequestParam(value="id", required = false) Long id ,Model model) {
		CategoryDTO categoryDTO = new CategoryDTO();
		if(id != null) {
			categoryDTO = categoryService.findById(id);
		}
		model.addAttribute("model",categoryDTO);
		return "viewsofadmin/editcategory";
	}
	
	@RequestMapping("category/search")
	public String search(Model model,@RequestParam("keyword") String keyword,   @RequestParam(value ="page",required = false) Integer page, 
			@RequestParam(value= "limit",required = false) Integer limit) {
		Pageable pageable;
		if(page == null & limit == null) {
			page = 1;
			limit = 5;
			 pageable = PageRequest.of(0, limit);
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		int totalPage = (int) Math.ceil((double) (categoryService.totalItem())/ limit);
		List<CategoryDTO> categoryDTO = categoryService.findByIsDeletedFalseAndNameLike(keyword, pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("list", categoryDTO);
		return "viewsofadmin/listcategory";
	}
	
	@RequestMapping(value = "category/delete/{id}")
	public String delete(@PathVariable("id") Long id ,Model model) {
		categoryService.isDeleted(Boolean.TRUE, id);
		return "redirect:/admin/category/list";
	}
	
}
