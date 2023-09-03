package com.capitole.electroniccommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capitole.electroniccommerce.payload.ApiResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * class for exception handling
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    
	/**
	 * handle not found 404 errors
	 * @param ex, messagge error
	 * @return apiResponse, payload
	 */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
    	ApiResponse apiResponse = ApiResponse.builder()
    			.messagge(ex.getMessage())
    			.url(ex.getUrl())
    			.uuid(ex.getUuid())
    			.build();

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
  
    /** 
     * controls logic errors or catch errors 400
     * @param ex, messagge error
     * @return apiResponse, payload 
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> handlerBadRequestException(MissingServletRequestParameterException ex) {
    	log.warn(ex.getMessage()); 
        ApiResponse apiResponse = ApiResponse.builder()
    			.messagge(ex.getMessage())
    			.url("")
    			.uuid("")
    			.build();
        
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * controls logic errors or catch errors  400
     * @param ex
     * @return apiResponse, payload
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> handlerBadRequestException(MethodArgumentTypeMismatchException ex) {
    	log.warn(ex.getMessage()); 
    	ApiResponse apiResponse = ApiResponse.builder()
    			.messagge(ex.getMessage())
    			.url("")
    			.uuid("")
    			.build();
        
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    
}
