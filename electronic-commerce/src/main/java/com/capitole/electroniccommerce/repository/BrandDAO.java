package com.capitole.electroniccommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capitole.electroniccommerce.entity.BrandEntity;

/**
 * crude repository for brands
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
public interface BrandDAO extends JpaRepository<BrandEntity, Long>{

}
