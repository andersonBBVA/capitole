package com.capitole.electroniccommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * DTO that represents the data that will be returned from prices
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Data
@Schema(description = "DTO to represent response")
@Builder
public class PriceResponseDTO {
	
	private Integer productId;
	private Long brandId;
	private BigDecimal price;  
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
