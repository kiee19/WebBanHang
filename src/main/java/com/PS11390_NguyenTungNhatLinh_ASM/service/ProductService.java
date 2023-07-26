package com.PS11390_NguyenTungNhatLinh_ASM.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findByIsDeletedFalse(Pageable pageable);
	List<ProductDTO> findByIsDeletedFalseAndNameLike(String keyword,Pageable pageable);
	List<ProductDTO> findByIsDeletedTrue(Pageable pageable);
	List<ProductDTO> findByIsDeletedTrueAndNameLike(String keyword,Pageable pageable);
	List<ProductDTO> findByIsDeletedFalseOrderByPriceAsc(Pageable pageable);
	List<ProductDTO> findByIsDeletedFalseOrderByPriceDesc(Pageable pageable);
	ProductDTO save(ProductDTO dto);
	void deleted(Long id);
	ProductDTO findById(Long id);
	int totalItem();
	void updateQuantity(Integer quantity, Long id);
	void isDeleted(Boolean isDeleted, Long id);
}
