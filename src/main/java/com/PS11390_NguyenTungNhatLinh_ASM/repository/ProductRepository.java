package com.PS11390_NguyenTungNhatLinh_ASM.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PS11390_NguyenTungNhatLinh_ASM.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	List<ProductEntity> findByIsDeleted(Boolean isDeleted,Pageable pageable);
	List<ProductEntity> findByIsDeletedAndNameLike(Boolean isDeleted,String keyword,Pageable pageable);
	List<ProductEntity> findByIsDeletedFalseOrderByPriceAsc(Pageable pageable);
	List<ProductEntity> findByIsDeletedFalseOrderByPriceDesc(Pageable pageable);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE product SET quantity = ?1 WHERE id = ?2", nativeQuery = true)
	void updateQuantity(Integer quantity, Long id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE product SET isdeleted = ?1 WHERE id = ?2", nativeQuery = true)
	void isDeleted(Boolean isDeleted, Long id);
}
