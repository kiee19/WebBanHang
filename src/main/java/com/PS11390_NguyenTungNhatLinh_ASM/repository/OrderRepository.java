package com.PS11390_NguyenTungNhatLinh_ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE orders SET status = ?1 WHERE id = ?2", nativeQuery = true)
	void updateStatus(String status, Long id);
}

