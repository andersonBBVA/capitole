package com.capitole.electroniccommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.electroniccommerce.entity.PriceEntity;

public interface PriceDAO extends JpaRepository<PriceEntity, Long> {

}
