package com.example.hotelbook.hotel.addHotel;

import com.example.hotelbook.hotel.HotelEntity;
import com.example.hotelbook.hotel.HotelRepository;
import com.example.hotelbook.hotel.dto.HotelRq;
import com.example.hotelbook.hotel.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateHotelHandlerImpl implements CreateHotelHandler {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    @Override
    public void addHotel(HotelRq hotelRq) {
        HotelEntity hotel = hotelMapper.toEntity(hotelRq);
        hotelRepository.save(hotel);
    }
}
