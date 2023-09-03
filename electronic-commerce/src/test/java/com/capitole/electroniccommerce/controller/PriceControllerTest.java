package com.capitole.electroniccommerce.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capitole.electroniccommerce.dto.PriceResponseDTO;
import com.capitole.electroniccommerce.payload.MessageResponse;

@SpringJUnitConfig
@SpringBootTest
@DisplayName("Tests de peticiones al endpoint REST")
class PriceControllerTest {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final Integer PRODUCT_ID = 35455;
	private static final Integer BRAND_ID = 1;
	
	//MOCK1
	private static final PriceResponseDTO MOCK1_EXPECTED_PRICE = PriceResponseDTO.builder()
            .productId(35455)
            .brandId(1L)
            .price(new BigDecimal("35.50"))
            .startDate(LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER))
            .endDate(LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER))
            .build();
	private static final MessageResponse MOCK1_MESSAGE = MessageResponse.builder()
			.message("Successful Operation")
			.object(MOCK1_EXPECTED_PRICE)
			.build();
	//MOCK2
	private static final PriceResponseDTO MOCK2_EXPECTED_PRICE = PriceResponseDTO.builder()
		    .productId(35455)
		    .brandId(1L)
		    .price(new BigDecimal("25.45"))
		    .startDate(LocalDateTime.parse("2020-06-14 15:00:00", DATE_TIME_FORMATTER))
		    .endDate(LocalDateTime.parse("2020-06-14 18:30:00", DATE_TIME_FORMATTER))
		    .build();
	private static final MessageResponse MOCK2_MESSAGE = MessageResponse.builder()
			.message("Successful Operation")
			.object(MOCK2_EXPECTED_PRICE)
			.build();
	//MOCK3
	private static final PriceResponseDTO MOCK3_EXPECTED_PRICE = PriceResponseDTO.builder()
	    .productId(35455)
	    .brandId(1L)
	    .price(new BigDecimal("30.50"))
	    .startDate(LocalDateTime.parse("2020-06-15 00:00:00", DATE_TIME_FORMATTER))
	    .endDate(LocalDateTime.parse("2020-06-15 11:00:00", DATE_TIME_FORMATTER))
	    .build();
	private static final MessageResponse MOCK3_MESSAGE = MessageResponse.builder()
			.message("Successful Operation")
			.object(MOCK3_EXPECTED_PRICE)
			.build();
	//MOCK4
	private static final PriceResponseDTO MOCK4_EXPECTED_PRICE = PriceResponseDTO.builder()
	    .productId(35455)
	    .brandId(1L)
	    .price(new BigDecimal("38.95"))
	    .startDate(LocalDateTime.parse("2020-06-15 16:00:00", DATE_TIME_FORMATTER))
	    .endDate(LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER))
	    .price(new BigDecimal("30.50").setScale(2, RoundingMode.HALF_UP))
	    .build();
	private static final MessageResponse MOCK4_MESSAGE = MessageResponse.builder()
			.message("Successful Operation")
			.object(MOCK4_EXPECTED_PRICE)
			.build();
	//MOCK5
	private static final PriceResponseDTO MOCK5_EXPECTED_PRICE = PriceResponseDTO.builder()
            .productId(35455)
            .brandId(1L)
            .price(new BigDecimal("35.50"))
            .startDate(LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER))
            .endDate(LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER))
            .build();
	private static final MessageResponse MOCK5_MESSAGE = MessageResponse.builder()
			.message("Successful Operation")
			.object(MOCK5_EXPECTED_PRICE)
			.build();	
    
    @Autowired
    private PriceController princeController;
 
    @Test
    @DisplayName("Test 1: request at 10:00 on the 14th for product 35455 for brand 1 (ZARA)")
    void test1() {    	
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 10:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(MOCK1_MESSAGE, price.getBody());
    }
    @Test
    @DisplayName("Test 2: request at 16:00 on the 14th for product 35455 for brand 1 (ZARA)")
    void test2() {    	
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 16:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(MOCK2_MESSAGE, price.getBody());
    }
    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test3() {   
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 21:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(MOCK3_MESSAGE, price.getBody());
    }
    @Test
    @DisplayName("Test 3: request at 9:00 p.m. on the 14th for product 35455 for brand 1 (ZARA)")
    void test4() {  
    	LocalDateTime date = LocalDateTime.parse("2020-06-15 10:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(MOCK4_MESSAGE, price.getBody());
    }
    @Test
    @DisplayName("Test 5: request at 9:00 p.m. on the 16th for product 35455 for brand 1 (ZARA)")
    void test5() {  
    	LocalDateTime date = LocalDateTime.parse("2020-06-16 21:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(MOCK5_MESSAGE, price.getBody());
    }

}
