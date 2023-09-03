package com.capitole.electroniccommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Entity represent table PRICES
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Entity
@Table(name = "\"PRICES\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	@Column(name = "START_DATE")
    private LocalDateTime startDate;
	@Column(name = "END_DATE")
    private LocalDateTime endDate;
	@Column(name = "PRICE_LIST")
    private Integer priceList;
	@Column(name = "PRODUCT_ID")
    private Integer productId;
	@Column(name = "PRICE")
	@NumberFormat(pattern = "#0.00")
    private BigDecimal price;  
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "CURR")
    private String currency;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID")
    private BrandEntity brandEntity;
}
