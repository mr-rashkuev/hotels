package com.example.hotelbook.booking.getbooking;

import com.example.hotelbook.booking.dto.BookingRs;

import java.util.List;

public interface GetBookingHandler {

    BookingRs findById(Long id);

    List<BookingRs> findAll();
}
