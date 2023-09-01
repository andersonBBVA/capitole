package com.capitole.electroniccommerce;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
class PricesEntityIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Test
    @DisplayName("Test 1: request to the table to validate that it is not empty")
	 void testPricesTableNotEmpty() {
	     List<Map<String, Object>> prices = jdbcTemplate.queryForList("SELECT * FROM PRICES");
	     assertTrue(prices.size() > 0, "The price table is not empty");
    }
    
    @Test
    @DisplayName("Test 2: request to the number 1 price of the number 1 brand of ZARA to validate fields")
	 void testPricesTableForFields() {
	     List<Map<String, Object>> prices = jdbcTemplate.queryForList("SELECT * FROM PRICES");
	     Map<String, Object> firstPrice = prices.get(0);

	     Integer expectedBrandId = 1;
	     Timestamp expectedStartDate = Timestamp.valueOf(LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER));
	     Timestamp expectedEndDate = Timestamp.valueOf(LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER));
	     Integer expectedPriceList = 1;
	     Integer expectedProductId = 35455;
	     Integer expectedPriority = 0;
	     BigDecimal expectedPrice = new BigDecimal("35.50");
	     String expectedCurr = "EUR";

	     assertEquals(expectedBrandId, firstPrice.get("BRAND_ID"));
	     assertEquals(expectedStartDate, firstPrice.get("START_DATE"));
	     assertEquals(expectedEndDate, firstPrice.get("END_DATE"));
	     assertEquals(expectedPriceList, firstPrice.get("PRICE_LIST"));
	     assertEquals(expectedProductId, firstPrice.get("PRODUCT_ID"));
	     assertEquals(expectedPriority, firstPrice.get("PRIORITY"));
	     assertEquals(expectedPrice, firstPrice.get("PRICE"));
	     assertEquals(expectedCurr, firstPrice.get("CURR"));
	 }
    
    
    
}