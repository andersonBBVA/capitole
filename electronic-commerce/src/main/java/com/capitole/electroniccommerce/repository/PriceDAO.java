package com.capitole.electroniccommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capitole.electroniccommerce.entity.PriceEntity;

public interface PriceDAO extends JpaRepository<PriceEntity, Integer> {

	 @Query("SELECT p FROM PriceEntity p WHERE p.productId = :productId AND  p.brandEntity.brandId = :brandId AND p.startDate <= :date AND p.endDate >= :date ORDER BY p.priority DESC LIMIT 1")	
	 List<PriceEntity> findPrice(@Param("productId") Integer productId, @Param("brandId") Integer brandId, @Param("date") LocalDateTime date);
}
