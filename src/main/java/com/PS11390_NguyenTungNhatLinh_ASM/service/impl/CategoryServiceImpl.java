package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.PS11390_NguyenTungNhatLinh_ASM.converter.CategoryConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.CategoryDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.CategoryEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.CategoryRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity entity = categoryConverter.toEntity(dto);
		entity.setIsDeleted(false);
		entity = categoryRepository.save(entity);
		return dto;
	}


	@Override
	public CategoryDTO findById(Long id) {
		Optional<CategoryEntity> entity = categoryRepository.findById(id);
		CategoryDTO dto = new CategoryDTO();
		if (entity.isPresent()) {
			BeanUtils.copyProperties(entity.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public int totalItem() {
		return (int) categoryRepository.count();
	}

	@Override
	public List<CategoryDTO> findByIsDeletedFalse(Pageable pageable) {
		List<CategoryEntity> entities = categoryRepository.findByIsDeleted(Boolean.FALSE, pageable);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<CategoryDTO> findByIsDeletedFalseAndNameLike(String keyword, Pageable pageable) {
		List<CategoryEntity> entities = categoryRepository.findByIsDeletedAndNameLike(Boolean.FALSE,
				"%" + keyword + "%", pageable);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<CategoryDTO> findByIsDeletedTrue(Pageable pageable) {
		List<CategoryEntity> entities = categoryRepository.findByIsDeleted(Boolean.TRUE, pageable);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<CategoryDTO> findByIsDeletedTrueAndNameLike(String keyword, Pageable pageable) {
		List<CategoryEntity> entities = categoryRepository.findByIsDeletedAndNameLike(Boolean.TRUE,
				"%" + keyword + "%", pageable);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<CategoryDTO> findByIsDeletedFalse() {
		List<CategoryEntity> entities = categoryRepository.findByIsDeleted(Boolean.FALSE);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (CategoryEntity item : entities) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void isDeleted(Boolean isDeleted, Long id) {
		categoryRepository.isDeleted(isDeleted, id);
	}


	@Override
	public void deleted(Long id) {
		categoryRepository.deleteById(id);
		
	}
}
