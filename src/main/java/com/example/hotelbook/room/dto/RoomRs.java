package com.example.hotelbook.room.dto;


import com.example.hotelbook.hotel.HotelEntity;
import com.example.hotelbook.room.RoomType;

public record RoomRs(
        Long id,
        String hotel,
        RoomType roomType,
        double price
) {
}
