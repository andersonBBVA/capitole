package com.capitole.electroniccommerce;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@SpringJUnitConfig
class ElectronicCommerceApplicationTests {
	
	@BeforeAll
	static void setup() {
	    log.info("@BeforeAll - executes once before all test methods in this class");
	}

	@BeforeEach
	void init() {
	    log.info("@BeforeEach - executes before each test method in this class");
	}
	
	@DisplayName("Single test successful")
	@Test
	void testSingleSuccessTest() {
	    log.info("Success");
	}

	@Test
	@Disabled("Not implemented yet")
	void testShowSomething() {
		log.info("Success");
	}
	
}
