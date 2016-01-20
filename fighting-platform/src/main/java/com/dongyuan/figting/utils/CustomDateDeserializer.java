package com.dongyuan.figting.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dongyuan.figting.Constants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {    
    
    private SimpleDateFormat sdf = new SimpleDateFormat(Constants.FORMAT_STR_DATETIME);    
    
    @Override    
    public Date deserialize(JsonParser jp, DeserializationContext ctxt)    
            throws IOException, JsonProcessingException {    
    
        Date date = null;    
        try {    
            date = sdf.parse(jp.getText());    
        } catch (ParseException e) {    
            e.printStackTrace();    
        }    
        return date;    
    } 
}
