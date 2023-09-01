package com.capitole.electroniccommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.electroniccommerce.entity.BrandEntity;

public interface BrandDAO extends JpaRepository<BrandEntity, Long>{

}
