package com.capitole.electroniccommerce.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *  payload representing response in an http request
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Data
@ToString
@Builder
@SuppressWarnings("serial")
public class MessageResponse  implements Serializable {
	
	private String message;
    private transient Object object;

}