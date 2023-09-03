package com.capitole.electroniccommerce.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capitole.electroniccommerce.dto.PriceResponseDTO;
import com.capitole.electroniccommerce.entity.PriceEntity;
import com.capitole.electroniccommerce.repository.PriceDAO;
import com.capitole.electroniccommerce.service.PriceService;

import lombok.extern.slf4j.Slf4j;

/** 
 * Service that defines the business logic for pricing 
 * @author 01061
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceDAO priceDAO;
	
	@Override
	public List<PriceResponseDTO> findPriceListByProduct(Integer productId, Integer brandId, LocalDateTime date) {
		log.info("Checking prices...");
		
		List<PriceEntity> listPriceEntity  = priceDAO.findPrice(productId, brandId, date);
		
		return listPriceEntity.stream()
			    .map(entity -> PriceResponseDTO.builder()
			    	.productId(entity.getProductId())
			    	.brandId(entity.getBrandEntity().getBrandId())
			    	.price(entity.getPrice())
			    	.startDate(entity.getStartDate())
			    	.endDate(entity.getEndDate())
			        .build())
			    .toList();
	}

}
