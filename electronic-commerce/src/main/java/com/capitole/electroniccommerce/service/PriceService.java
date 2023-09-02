package com.capitole.electroniccommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capitole.electroniccommerce.entity.PriceEntity;

public interface PriceService {

	List<PriceEntity> findPriceListByProduct(Integer productId, Integer brandId, LocalDateTime date);
}
