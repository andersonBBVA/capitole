package com.capitole.electroniccommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Entity represent table BRANDS
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Entity
@Table(name = "\"BRANDS\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRAND_ID")
    private Long brandId;
	
	@Column(name="NAME")
	private String name;
	
}
