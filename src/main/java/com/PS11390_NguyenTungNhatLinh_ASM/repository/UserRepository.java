package com.PS11390_NguyenTungNhatLinh_ASM.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PS11390_NguyenTungNhatLinh_ASM.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByUsername(String username);
	List<UserEntity> findByIsDeleted(Boolean isDeleted,Pageable pageable);
	List<UserEntity> findByIsDeletedAndFullnameLike(Boolean isDeleted,String keyword,Pageable pageable);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE user SET isdeleted = ?1 WHERE id = ?2", nativeQuery = true)
	void isDeleted(Boolean isDeleted, Long id);
}
