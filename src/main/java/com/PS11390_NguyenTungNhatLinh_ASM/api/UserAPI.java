package com.PS11390_NguyenTungNhatLinh_ASM.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.service.UserService;

@RestController
@CrossOrigin
public class UserAPI {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/user")
	public UserDTO create(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@PutMapping("/api/user")
	public UserDTO update(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@DeleteMapping("/api/user")
	public void delete(@RequestBody Long id) {
		userService.delete(id);
	}
}
