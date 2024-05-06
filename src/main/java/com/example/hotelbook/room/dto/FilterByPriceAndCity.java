package com.example.hotelbook.room.dto;

public record FilterByPriceAndCity(

        double low,
        double high,
        String city
) {
}
