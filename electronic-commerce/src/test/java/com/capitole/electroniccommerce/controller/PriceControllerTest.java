package com.capitole.electroniccommerce.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
import com.capitole.electroniccommerce.exception.ResourceNotFoundException;
import com.capitole.electroniccommerce.payload.MessageResponse;

@SpringJUnitConfig
@SpringBootTest
@DisplayName("Tests de peticiones al endpoint REST")
class PriceControllerTest {

	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final Integer PRODUCT_ID = 35455;
	private static final Integer BRAND_ID = 1;
	
	 @Autowired
    private PriceController princeController;
	 
    private PriceResponseDTO createPriceResponseDTO(Integer productId,Long brandId, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate) {
        return PriceResponseDTO.builder()
                .productId(productId)
                .brandId(brandId)
                .price(price)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

    private MessageResponse createMessageResponse(PriceResponseDTO expectedPrice) {
        return MessageResponse.builder()
                .message("Successful Operation")
                .object(expectedPrice)
                .build();
    }
    
    @Test
    @DisplayName("Test 1: request at 10:00 on the 14th for product 35455 for brand 1 (ZARA)")
    void test1() {    	
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 10:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	
    	PriceResponseDTO expectedPrice = createPriceResponseDTO(
    			35455,
    			1L,
                new BigDecimal("35.50"),
                LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER));

        MessageResponse expectedMessage = createMessageResponse(expectedPrice);
        
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(expectedMessage, price.getBody());
    }
    
    @Test
    @DisplayName("Test 2: request at 16:00 on the 14th for product 35455 for brand 1 (ZARA)")
    void test2() {    	
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 16:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	
       	PriceResponseDTO expectedPrice = createPriceResponseDTO(
    			35455,
    			1L,
                new BigDecimal("25.45"),
                LocalDateTime.parse("2020-06-14 15:00:00", DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-06-14 18:30:00", DATE_TIME_FORMATTER));

        MessageResponse expectedMessage = createMessageResponse(expectedPrice);
   
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(expectedMessage, price.getBody());
    }
    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test3() {   
    	LocalDateTime date = LocalDateTime.parse("2020-06-14 21:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	
       	PriceResponseDTO expectedPrice = createPriceResponseDTO(
    			35455,
    			1L,
                new BigDecimal("30.50"),
                LocalDateTime.parse("2020-06-15 00:00:00", DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-06-15 11:00:00", DATE_TIME_FORMATTER));

        MessageResponse expectedMessage = createMessageResponse(expectedPrice);
    	
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(expectedMessage, price.getBody());
    }
    @Test
    @DisplayName("Test 3: request at 9:00 p.m. on the 14th for product 35455 for brand 1 (ZARA)")
    void test4() {  
    	LocalDateTime date = LocalDateTime.parse("2020-06-15 10:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	
       	PriceResponseDTO expectedPrice = createPriceResponseDTO(
    			35455,
    			1L,
                new BigDecimal("38.95"),
                LocalDateTime.parse("2020-06-15 16:00:00", DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER));

        MessageResponse expectedMessage = createMessageResponse(expectedPrice);
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(expectedMessage, price.getBody());
    }
    @Test
    @DisplayName("Test 5: request at 9:00 p.m. on the 16th for product 35455 for brand 1 (ZARA)")
    void test5() {  
    	LocalDateTime date = LocalDateTime.parse("2020-06-16 21:00:00", DATE_TIME_FORMATTER);
    	ResponseEntity<MessageResponse> price = princeController.getPrice(PRODUCT_ID, BRAND_ID, date);
    	
       	PriceResponseDTO expectedPrice = createPriceResponseDTO(
    			35455,
    			1L,
                new BigDecimal("35.50"),
                LocalDateTime.parse("2020-06-14 00:00:00", DATE_TIME_FORMATTER),
                LocalDateTime.parse("2020-12-31 23:59:59", DATE_TIME_FORMATTER));

        MessageResponse expectedMessage = createMessageResponse(expectedPrice);
        
    	assertEquals(HttpStatus.OK, price.getStatusCode());
    	assertEquals(expectedMessage, price.getBody());
    }
    @Test
    @DisplayName("Test 6: Not found request for the year 2023 at 9:00 p.m. on the 16th for product 35455 for brand 1 (ZARA)")
    void test6() {  
    	LocalDateTime date = LocalDateTime.parse("2023-06-16 21:00:00", DATE_TIME_FORMATTER); 
    	assertThrows(ResourceNotFoundException.class, 
    			()->princeController.getPrice(PRODUCT_ID, BRAND_ID, date));     
    }
    
}
