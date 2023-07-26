package com.PS11390_NguyenTungNhatLinh_ASM.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CartDetailDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderDetailService;
import com.PS11390_NguyenTungNhatLinh_ASM.service.OrderService;

@Controller
@RequestMapping("/admin/")
public class ReportController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("report/list")
	public String list(Model model) {
		List<OrderEntity> orders = orderService.findAll();
		model.addAttribute("items", orders);
		return "viewsofadmin/listorder";
	}
	
	@GetMapping("order-detail/{id}")
	public String OrderDetailList(Model model, @PathVariable("id") Long orderId) {
		List<CartDetailDTO> cartDetail = orderDetailService.findByOrderId(orderId);
		model.addAttribute("items", cartDetail);
		return "viewsofadmin/listorderdetail";
	}
	
	@RequestMapping("/order/edit")
	public String edit(@RequestParam("id") Long id,@RequestParam("status") String status ) {
		if(status.equals("Chưa giao hàng")) {
			status = "Đã giao hàng";
			orderService.updateStatus(status, id);
		}else {
			status = "Chưa giao hàng";
			orderService.updateStatus(status, id);
		}
		return "redirect:/admin/report/list";
	}
}
