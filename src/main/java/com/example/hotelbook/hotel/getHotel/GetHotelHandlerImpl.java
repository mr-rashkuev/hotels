package com.example.hotelbook.hotel.getHotel;

import com.example.hotelbook.hotel.HotelRepository;
import com.example.hotelbook.hotel.dto.HotelRs;
import com.example.hotelbook.hotel.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetHotelHandlerImpl implements GetHotelHandler {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Override
    public HotelRs findById(Long id){
        return hotelMapper.toDto(hotelRepository.findById(id).orElseThrow());
    }

    @Override
    public List<HotelRs> findAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
    }
}
