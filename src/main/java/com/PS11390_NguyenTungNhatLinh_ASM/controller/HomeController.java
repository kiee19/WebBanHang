package com.PS11390_NguyenTungNhatLinh_ASM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@Controller(value="controllerOfWeb")

public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/home")
	public String home(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
		List<ProductDTO> dto = productService.findByIsDeletedFalse(pageable);
		model.addAttribute("items", dto);
		CartDTO currentCart = (CartDTO) session.getAttribute("currentCart");
		if (ObjectUtils.isEmpty(currentCart)) {
			session.setAttribute("currentCart", new CartDTO());
		}
		return "viewsofweb/home";
	}

	@RequestMapping("/shoppage")
	public String shopPage(Model model, @RequestParam(value ="page",required = false) Integer page, 
			@RequestParam(value= "limit",required = false) Integer limit, @RequestParam(value="order-by", required = false) String sort) {
		Pageable pageable;
		if(page == null & limit == null) {
			page = 1;
			limit = 8;
			 pageable = PageRequest.of(0, limit);
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		int totalPage = (int) Math.ceil((double) (productService.totalItem())/ limit);
		List<ProductDTO> dto = new ArrayList<>();
		if(sort != null) {
			if(sort.equals("asc")) {
				dto = productService.findByIsDeletedFalseOrderByPriceAsc(pageable);
			}else if(sort.equals("desc")){
				dto = productService.findByIsDeletedFalseOrderByPriceDesc(pageable);
			}
			model.addAttribute("sort", sort);
		}else {
			 dto = productService.findByIsDeletedFalse(pageable);
		}
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofweb/shoppage";
	}
	@GetMapping("/single-product/{id}")
	public String singleProduct(@PathVariable(value="id", required = false) Long id ,Model model) {
		ProductDTO productDTO = new ProductDTO();
		if(id != null) {
			productDTO = productService.findById(id);
		}
		model.addAttribute("item",productDTO);
		return "viewsofweb/single-product";
	}
	
	@RequestMapping("/shoppage/search")
	public String search(Model model,@RequestParam("keyword") String keyword,  @RequestParam(value ="page",required = false) Integer page, 
			@RequestParam(value= "limit",required = false) Integer limit) {
		Pageable pageable;
		if(page == null & limit == null) {
			page = 1;
			limit = 8;
			 pageable = PageRequest.of(0, limit);
		}else {
			pageable = PageRequest.of(page-1, limit);
		}
		int totalPage = (int) Math.ceil((double) (productService.totalItem())/ limit);
		List<ProductDTO> dto = productService.findByIsDeletedFalseAndNameLike(keyword,pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofweb/shoppage";
	}
}
