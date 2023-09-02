package com.capitole.electroniccommerce.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.electroniccommerce.entity.PriceEntity;
import com.capitole.electroniccommerce.repository.PriceDAO;
import com.capitole.electroniccommerce.service.PriceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceDAO priceDAO;
	
	@Override
	public List<PriceEntity> findPriceListByProduct(Integer productId, Integer brandId, LocalDateTime date) {
		log.info("Checking prices...");
		return priceDAO.findPrice(productId, brandId, date);
	}

}
