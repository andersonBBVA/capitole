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
	
	private APIConsts () {
		
	}

	public static final String CONTROLLER_PRICES = "/v1/prices";
	public static final String CONTROLLER_PRICES_GET = "/find";
	
	
	/**
	 * Method description
	 */
	
	public static final String NOTE_API_OPERATION_GET_SUMMARY ="Finds the price.";
	public static final String NOTE_API_OPERATION_GET_DESC ="Finds the price for a product id, brand id and  date., returning a list.";
	public static final String NOTE_API_OPERATION_GET_DESC_400="""
			{
			    "date": "2023-09-03T18:37:15.067+00:00",
			    "messagge": "Required request parameter 'brandId' for method parameter type Integer is not present",
			    "url": "",
			    "uuid": ""
			}
			
			""";
	public static final String NOTE_API_OPERATION_GET_DESC_404="""
			{
			    "date": "2023-09-03T18:22:24.453+00:00",
			    "messagge": "Price was not found : '/find' , '0771b58c-83a9-411f-b251-a289d400319b'",
			    "url": "/find",
			    "uuid": "0771b58c-83a9-411f-b251-a289d400319b"
			}
			""";
	/**
	 * Response messages according to http code
	 */
	public static final String API_RESPONSE_COD_200 = "OK";
	
}
