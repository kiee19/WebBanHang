package com.PS11390_NguyenTungNhatLinh_ASM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.PS11390_NguyenTungNhatLinh_ASM.converter.UserConverter;
import com.PS11390_NguyenTungNhatLinh_ASM.dto.UserDTO;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.UserEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.repository.UserRepository;
import com.PS11390_NguyenTungNhatLinh_ASM.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Override
	public UserDTO save(UserDTO dto) {
		UserEntity userEntity = userConverter.toEntity(dto);
		userEntity.setHashPassword(bcrypt.encode(dto.getHashPassword()));
		userEntity.setIsDeleted(false);
		userEntity = userRepository.save(userEntity);
		return dto;
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<UserEntity> entity = userRepository.findById(id);
		if(entity.isPresent()) {
			UserDTO dto = userConverter.toDTO(entity.get());
			return dto;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO login(String username, String password) {
		UserDTO userDTO = findByUsername(username);
		boolean checkPass = false;
		if(!ObjectUtils.isEmpty(userDTO)) {
			String hashPass = userDTO.getHashPassword();
			checkPass = bcrypt.matches(password, hashPass);
		}
		return checkPass ? userDTO : null;
	}

	@Override
	public UserDTO findByUsername(String username) {
		UserEntity entity = userRepository.findByUsername(username);
		if(entity != null) {
			UserDTO dto = userConverter.toDTO(entity);
			return dto;
		}
		return null;
	}
	
	
	@Override
	public int totalItem() {
		return (int)  userRepository.count();
	}

	@Override
	public List<UserDTO> findByIsDeletedFalse(Pageable pageable) {
		List<UserEntity> entities = userRepository.findByIsDeleted(Boolean.FALSE,pageable);
		List<UserDTO> dtos = new ArrayList<>();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> findByIsDeletedFalseAndFullnameLike(String keyword, Pageable pageable) {
		List<UserEntity> entities = userRepository.findByIsDeletedAndFullnameLike(Boolean.FALSE,"%"+keyword+"%", pageable);
		List<UserDTO> dtos = new ArrayList<>();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> findByIsDeletedTrue(Pageable pageable) {
		List<UserEntity> entities = userRepository.findByIsDeleted(Boolean.TRUE,pageable);
		List<UserDTO> dtos = new ArrayList<>();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<UserDTO> findByIsDeletedTrueAndFullnameLike(String keyword, Pageable pageable) {
		List<UserEntity> entities = userRepository.findByIsDeletedAndFullnameLike(Boolean.TRUE,"%"+keyword+"%", pageable);
		List<UserDTO> dtos = new ArrayList<>();
		for (UserEntity item : entities) {
			UserDTO dto = userConverter.toDTO(item);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void isDeleted(Boolean isDeleted, Long id) {
		userRepository.isDeleted(isDeleted, id);
	}
	
	
}
