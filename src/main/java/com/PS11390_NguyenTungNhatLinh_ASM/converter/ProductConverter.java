package com.PS11390_NguyenTungNhatLinh_ASM.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.ProductDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.CategoryEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.ProductEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.CategoryRepository;

@Component
public class ProductConverter {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	@Autowired
//	private StorageService storageService;
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		CategoryEntity categoryEntity = entity.getCategoryId();
		BeanUtils.copyProperties(entity, dto);
		dto.setCategoryCode(categoryEntity.getCode());
		return dto;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		CategoryEntity categoryEntity = categoryRepository.findByCode(dto.getCategoryCode());
		BeanUtils.copyProperties(dto, entity);
		entity.setCategoryId(categoryEntity);
		
		return entity;
	}
}
