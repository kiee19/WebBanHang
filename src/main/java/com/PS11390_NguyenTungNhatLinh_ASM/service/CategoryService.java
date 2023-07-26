package com.PS11390_NguyenTungNhatLinh_ASM.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> findByIsDeletedFalse();
	List<CategoryDTO> findByIsDeletedFalse(Pageable pageable);
	List<CategoryDTO> findByIsDeletedFalseAndNameLike(String keyword,Pageable pageable);
	List<CategoryDTO> findByIsDeletedTrue(Pageable pageable);
	List<CategoryDTO> findByIsDeletedTrueAndNameLike(String keyword,Pageable pageable);
	CategoryDTO save(CategoryDTO dto);
	CategoryDTO findById(Long id);
	int totalItem();
	void deleted(Long id);
	void isDeleted(Boolean isDeleted, Long id);
}
