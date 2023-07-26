package com.PS11390_NguyenTungNhatLinh_ASM.controller.admin.bin;

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

import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.RoleRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.UserService;

@Controller
@RequestMapping("/admin/")
public class UserBinController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/user-bin/list")
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
		int totalPage = (int) Math.ceil((double) (userService.totalItem())/ limit);
		List<UserDTO> dto = userService.findByIsDeletedTrue(pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listuserbin";
	}
	
	@RequestMapping("/user-bin/search")
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
		int totalPage = (int) Math.ceil((double) (userService.totalItem())/ limit);
		List<UserDTO> dto = userService.findByIsDeletedTrueAndFullnameLike(keyword,pageable);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("items", dto);
		return "viewsofadmin/listuserbin";
	}
	
	@RequestMapping(value = "user-bin/restore/{id}")
	public String delete(@PathVariable("id") Long id ,Model model) {
		userService.isDeleted(Boolean.FALSE, id);
		return "redirect:/admin/user-bin/list";
	}
}
