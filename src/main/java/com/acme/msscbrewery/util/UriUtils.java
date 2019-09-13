package com.acme.msscbrewery.util;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UriUtils {

    public static String expandUriAsString(UriComponentsBuilder builder){
        UriComponents request = builder.build(true);
        String scheme = request.getScheme();
        String host = request.getHost();
        int port = request.getPort();
        String path = request.getPath();

        String expandedUri = String.format("%s://%s:%s/%s",
                            scheme, 
                            host, 
                            port, 
                            path);
    
        return expandedUri;
    }
    

}