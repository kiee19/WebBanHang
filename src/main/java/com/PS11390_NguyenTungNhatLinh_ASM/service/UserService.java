package com.PS11390_NguyenTungNhatLinh_ASM.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;

public interface UserService {
	UserDTO save(UserDTO dto);
	UserDTO findById(Long id);
	void delete(Long id);
	UserDTO login(String username, String password);
	UserDTO findByUsername(String username);
	List<UserDTO> findByIsDeletedFalse(Pageable pageable);
	List<UserDTO> findByIsDeletedFalseAndFullnameLike(String keyword,Pageable pageable);
	List<UserDTO> findByIsDeletedTrue(Pageable pageable);
	List<UserDTO> findByIsDeletedTrueAndFullnameLike(String keyword,Pageable pageable);
	int totalItem();
	void isDeleted(Boolean isDeleted, Long id);
}
