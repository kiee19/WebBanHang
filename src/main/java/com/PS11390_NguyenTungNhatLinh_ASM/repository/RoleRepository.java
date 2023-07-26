package com.PS11390_NguyenTungNhatLinh_ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS11390_NguyenTungNhatLinh_ASM.entity.RoleEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findByCode(String code);
}
