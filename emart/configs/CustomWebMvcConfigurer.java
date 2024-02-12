package com.emart.configs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.emart.entities.Order;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MyCustomMessageConverter());
    }

    private static class MyCustomMessageConverter extends AbstractHttpMessageConverter<Object> {

        public MyCustomMessageConverter() {
            super(MediaType.APPLICATION_JSON); // Specify supported media type(s)
        }

        @Override
        protected boolean supports(Class<?> clazz) {
            // Return true if the class is supported for conversion
            return clazz.isAssignableFrom(Order.class);
        }

        @Override
        protected void writeInternal(Object object, HttpOutputMessage outputMessage)
                throws IOException {
            // Convert the object to the desired format and write to the output stream
            String data = object.toString();
            outputMessage.getBody().write(data.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
                throws IOException {
            // Implement if needed for reading from the input message
            return null;
        }
    }
}
