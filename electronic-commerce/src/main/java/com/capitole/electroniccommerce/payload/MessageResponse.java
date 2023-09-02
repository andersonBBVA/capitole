package com.capitole.electroniccommerce.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Builder
@SuppressWarnings("serial")
public class MessageResponse  implements Serializable {
	
	private String message;
    private transient Object object;

}