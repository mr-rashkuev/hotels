package com.example.hotelbook.booking.dto;

import java.time.LocalDate;

public record BookingRq(
        Long room,
        Long guest,
        LocalDate checkIn,
        LocalDate checkOut
) {
}
