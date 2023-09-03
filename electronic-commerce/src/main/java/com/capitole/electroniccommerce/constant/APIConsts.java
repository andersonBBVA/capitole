package com.capitole.electroniccommerce.constant;

/**
 * Constants for Open API management
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
public class APIConsts {
	
	/**
	 * Path controller price
	 */

	public static final String CONTROLLER_PRICES = "/v1/prices";
	
	/**
	 * Method description
	 */
	
	public static final String NOTE_API_OPERATION_GET_SUMMARY ="Finds the price.";
	public static final String NOTE_API_OPERATION_GET_DESC ="Finds the price for a product id, brand id and  date., returning a list.";
	
	/**
	 * Response messages according to http code
	 */
	public static final String API_RESPONSE_COD_200 = "OK";
	
}
