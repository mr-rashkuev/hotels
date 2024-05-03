package com.example.hotelbook;

import com.example.hotelbook.booking.createbooking.AccountClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final String url = "http://localhost:8081";

    public AccountClient accountClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AccountClient.class, url);
    }

}
