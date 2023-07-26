package com.PS11390_NguyenTungNhatLinh_ASM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderDetailEntity;
import com.PS11390_NguyenTungNhatLinh_ASM.entity.OrderEntity;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long>{
	List<OrderDetailEntity> findByOrderId(OrderEntity orderId);
}
