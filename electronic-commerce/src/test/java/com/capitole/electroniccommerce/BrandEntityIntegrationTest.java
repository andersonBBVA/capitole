package com.capitole.electroniccommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;



@SpringJUnitConfig
@SpringBootTest
class BrandEntityIntegrationTest {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("Test 1: request to the table to validate that it is not empty")
	 void testBrandsTableNotEmpty() {
	     List<Map<String, Object>> brands = jdbcTemplate.queryForList("SELECT * FROM BRANDS");
	     assertTrue(brands.size() > 0, "The brand table is not empty");
    }
    
    @Test
    @DisplayName("Test 2: request to the ZARA chain to validate fields")
	 void testBrandsForFieldse() {
    	
    	 Integer findBrandId = 1;
	     List<Map<String, Object>> brands = jdbcTemplate.queryForList("SELECT * FROM BRANDS WHERE BRAND_ID="+findBrandId);
	     Map<String, Object> firstBrand = brands.get(0);

	     Integer expectedBrandId = 1;
	     String expectedName = "Zara";

	     assertEquals(expectedBrandId, firstBrand.get("BRAND_ID"));
	     assertEquals(expectedName, firstBrand.get("NAME"));
	 }

}
