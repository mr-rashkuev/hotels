package com.example.hotelbook.room.dto;

import com.example.hotelbook.hotel.HotelEntity;
import com.example.hotelbook.room.RoomType;


public record RoomRq(

         Long hotel,
         RoomType roomType,
         double price,
         int roomQuantity
) {
}
