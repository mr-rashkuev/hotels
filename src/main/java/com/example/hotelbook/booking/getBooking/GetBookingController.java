package com.example.hotelbook.booking.getBooking;


import com.example.hotelbook.booking.dto.BookingRs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking/")
public class GetBookingController {

    private final GetBookingHandler getBookingHandler;

    @GetMapping("{id}")
    public BookingRs getById(@PathVariable Long id){
        return getBookingHandler.findById(id);
    }

    @GetMapping
    public List<BookingRs> getBookings(){
        return getBookingHandler.findAll();
    }
}
