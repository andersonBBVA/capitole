package com.capitole.electroniccommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for bad request
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestException(String mensaje) {
        super(mensaje);
    }
}