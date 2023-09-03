package com.capitole.electroniccommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import com.capitole.electroniccommerce.dto.PriceResponseDTO;

/**
 * Service of prices
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
public interface PriceService {

	/**
	 * 
	 * @param productId; Product identifier
	 * @param brandId; Brand identifier
	 * @param date;Date for which you want to search the price return prices filtered by date
	 * @return
	 */
	public List<PriceResponseDTO> findPriceListByProduct(Integer productId, Integer brandId, LocalDateTime date);
}
