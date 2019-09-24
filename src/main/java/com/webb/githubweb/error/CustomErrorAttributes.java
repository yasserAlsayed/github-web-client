package com.webb.githubweb.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
	 private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	    @Override
	    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

	        // Let Spring handle the error first, we will modify later :)
	        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

	        // format & update timestamp
	        Object timestamp = errorAttributes.get("timestamp");
	        if (timestamp == null) {
	            errorAttributes.put("timestamp", dateFormat.format(new Date()));
	        } else {
	            errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
	        }

	        // insert a new key
	        errorAttributes.put("version", "1.0");

	        return errorAttributes;

	    }

}
