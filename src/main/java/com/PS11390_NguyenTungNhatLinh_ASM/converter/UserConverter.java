package com.PS11390_NguyenTungNhatLinh_ASM.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.RoleEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.UserEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.RoleRepository;

@Component
public class UserConverter {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		RoleEntity roleEntity = entity.getRoleId();
		BeanUtils.copyProperties(entity, dto);
		dto.setRoleCode(roleEntity.getCode());
		return dto;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		RoleEntity roleEntity = roleRepository.findByCode(dto.getRoleCode());
		BeanUtils.copyProperties(dto, entity);
		entity.setRoleId(roleEntity);
		return entity;
	}
}
