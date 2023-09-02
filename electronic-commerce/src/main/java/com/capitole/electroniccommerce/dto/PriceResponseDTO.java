package com.capitole.electroniccommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

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
