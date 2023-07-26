package com.PS11390_NguyenTungNhatLinh_ASM.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
}
