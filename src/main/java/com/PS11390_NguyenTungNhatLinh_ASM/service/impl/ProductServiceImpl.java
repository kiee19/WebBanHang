package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.PS11390_NguyenTungNhatLinh_ASM.converter.ProductConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.ProductEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.ProductRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public ProductDTO save(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity = productConverter.toEntity(dto);
		entity.setIsDeleted(false);
		entity = productRepository.save(entity);
		return dto;
	}

	@Override
	public void deleted(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public int totalItem() {
		return (int) productRepository.count();
	}

	@Override
	public void updateQuantity(Integer quantity, Long id) {
		productRepository.updateQuantity(quantity, id);
	}

	@Override
	public ProductDTO findById(Long id) {
		Optional<ProductEntity> entity = productRepository.findById(id);
		if (entity != null) {
			ProductDTO dto = productConverter.toDTO(entity.get());
			return dto;
		}
		return null;
	}

	@Override
	public List<ProductDTO> findByIsDeletedFalse(Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeleted(Boolean.FALSE, pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> findByIsDeletedFalseAndNameLike(String keyword, Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeletedAndNameLike(Boolean.FALSE, "%" + keyword + "%",
				pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> findByIsDeletedTrue(Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeleted(Boolean.TRUE, pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> findByIsDeletedTrueAndNameLike(String keyword, Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeletedAndNameLike(Boolean.TRUE, "%" + keyword + "%",
				pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> findByIsDeletedFalseOrderByPriceAsc(Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeletedFalseOrderByPriceAsc(pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ProductDTO> findByIsDeletedFalseOrderByPriceDesc(Pageable pageable) {
		List<ProductEntity> entities = productRepository.findByIsDeletedFalseOrderByPriceDesc(pageable);
		List<ProductDTO> dtos = new ArrayList<>();
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void isDeleted(Boolean isDeleted, Long id) {
		productRepository.isDeleted(isDeleted, id);
		
	}

}
