package com.example.hotelbook.booking.addBooking;


import com.example.hotelbook.booking.dto.BookingRq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking/")
public class CreateBookingController {

    private final CreateBookingHandler createBookingHandler;

    @PostMapping
    public void addBooking(@RequestBody BookingRq bookingRq){
        createBookingHandler.addBooking(bookingRq);
    }
}
