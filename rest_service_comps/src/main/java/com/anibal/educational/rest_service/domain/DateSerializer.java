package com.anibal.educational.rest_service.domain;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

@SuppressWarnings("serial")
public class DateSerializer extends StdSerializer<Date> {
    
   public DateSerializer() {
       this(null);
   }
  
   public DateSerializer(Class<Date> t) {
       super(t);
   }

   @Override
   public void serialize(
     Date value, JsonGenerator jgen, SerializerProvider provider) 
     throws IOException, JsonProcessingException {
	   
	   if(value==null)
		   jgen.writeNull();
	    
	   jgen.writeNumber(""+value.getTime());
   }

}
