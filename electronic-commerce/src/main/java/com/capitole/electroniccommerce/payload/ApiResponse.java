package com.capitole.electroniccommerce.payload;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  payload representing response in an http request for execptions
 * @author Anderson casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@SuppressWarnings("serial")
public class ApiResponse implements Serializable {
	
	@Builder.Default
    private Date date = new Date();
    private String messagge;
    private String url;
    private String uuid;

    public ApiResponse(String messagge, String url, String uuid) {
        this.messagge = messagge;
        this.url = url.replace("uri=","");
        this.uuid = uuid;
    }
    
}
