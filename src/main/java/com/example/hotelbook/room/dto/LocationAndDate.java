package com.example.hotelbook.room.dto;

import java.time.LocalDate;

public record LocationAndDate (

        String city,
        LocalDate checkIn,
        LocalDate checkOut
){

}
