package com.example.hotelbook.booking.dto;

import com.example.hotelbook.room.RoomType;

import java.time.LocalDate;

public record BookingRs(
        RoomType room,
        String guest,
        LocalDate checkIn,
        LocalDate checkOut
) {
}
