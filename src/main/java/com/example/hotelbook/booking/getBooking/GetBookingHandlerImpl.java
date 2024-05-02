package com.example.hotelbook.booking.getBooking;

import com.example.hotelbook.booking.BookingRepository;
import com.example.hotelbook.booking.dto.BookingRs;
import com.example.hotelbook.booking.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetBookingHandlerImpl implements GetBookingHandler {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingRs findById(Long id) {
        return bookingMapper.toDto(bookingRepository.findById(id).orElseThrow());
    }

    @Override
    public List<BookingRs> findAll() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }
}
