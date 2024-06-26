package com.example.hotelbook.room.dto;

import com.example.hotelbook.room.RoomType;
import lombok.Builder;


@Builder
public record RoomAvailableRs(

        Long id,
        String hotel,
        RoomType roomType,
        double price,
        int roomQuantity

) {
}
