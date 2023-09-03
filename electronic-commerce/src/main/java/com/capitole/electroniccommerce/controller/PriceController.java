package com.capitole.electroniccommerce.controller;

import java.time.LocalDateTime;
import java.util.List;

import static com.capitole.electroniccommerce.constant.APIConsts.CONTROLLER_PRICES;
import static com.capitole.electroniccommerce.constant.APIConsts.NOTE_API_OPERATION_GET_SUMMARY;
import static com.capitole.electroniccommerce.constant.APIConsts.NOTE_API_OPERATION_GET_DESC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.server.ResponseStatusException;

import com.capitole.electroniccommerce.dto.PriceResponseDTO;
import com.capitole.electroniccommerce.payload.MessageResponse;
import com.capitole.electroniccommerce.service.PriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


/**
 * Controller that exposes functionality for product prices
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Slf4j
@RestController
@RequestMapping(CONTROLLER_PRICES)
@Tag(name = "Prices", description = "API for Prices")
public class PriceController {
	
	@Autowired
    private PriceService priceService;

	@Operation(summary=NOTE_API_OPERATION_GET_SUMMARY, 
			description=NOTE_API_OPERATION_GET_DESC)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "200", 
				description = "Successful Operation",
				content = @Content(mediaType = "application/json", 
				schema = @Schema(implementation = MessageResponse.class))),
    		@ApiResponse(responseCode = "400", 
    			description = "Bad request", 
    			content = @Content(schema = @Schema(implementation=String.class),
    			examples = @ExampleObject(
    				value="400 BAD_REQUEST All application parameters are required"))),
    		@ApiResponse(responseCode = "401", description = "Authentication Failure",
      			content = @Content(schema = @Schema(hidden = true))),
    		@ApiResponse(responseCode = "404", 
				description = "Price not found", 
				content= {@Content(mediaType = "application/json",
				schema = @Schema(implementation = String.class),
				examples = @ExampleObject(
					value = "404 NOT_FOUND Price was not found"))}),
    		@ApiResponse(responseCode = "500", 
    			description = "Internal Server error ", 
    			content=@Content(schema = @Schema(implementation = ErrorResponse.class),
    			examples = @ExampleObject(
    				value = "500 INTERNAL_SERVER_ERROR Something went wrong")))
    })
	@GetMapping(value="/find", produces="application/json")
	public ResponseEntity<MessageResponse> getPrice(
	        @RequestParam @Parameter(description = "Product Id", example = "35455") Integer productId,
	        @RequestParam @Parameter(description = "Brand Id", example = "1") Integer brandId,
	        @RequestParam @Parameter(description = "Date with format yyyy-MM-dd HH:mm:ss", example = "2020-06-14 00:00:00") 
	        						@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date
	    ) {
    	try {
    		List<PriceResponseDTO> priceResponseDTO = priceService.findPriceListByProduct(productId, brandId, date);
    		log.info(priceResponseDTO.toString());
    		
    		if (priceResponseDTO == null || priceResponseDTO.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Price was not found");
            }
    		
    		log.info("Returning list...");
            return new ResponseEntity<>(
            		MessageResponse.builder()
                            .message("Successful Operation")
                            .object( priceResponseDTO)
                            .build()
                    , HttpStatus.OK);
            
		} catch (InternalServerError e) {
			log.error(e.getLocalizedMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong");
		}
	}

}
