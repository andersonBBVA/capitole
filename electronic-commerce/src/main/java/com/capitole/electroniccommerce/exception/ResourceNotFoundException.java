package com.capitole.electroniccommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

/**
 * class for Exception not fount
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final String url;
    private final String uuid;

    public ResourceNotFoundException(String messagge, String uuid, String url) {
    	super(String.format("%s : '%s' , '%s'", messagge, url, uuid));
        this.url = url.replace("uri=","");
        this.uuid = uuid;
    }
  
}
