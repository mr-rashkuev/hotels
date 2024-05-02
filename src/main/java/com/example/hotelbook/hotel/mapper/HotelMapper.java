package com.example.hotelbook.hotel.mapper;

import com.example.hotelbook.hotel.HotelEntity;

import com.example.hotelbook.hotel.dto.HotelRq;
import com.example.hotelbook.hotel.dto.HotelRs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelRs toDto(HotelEntity hotel);

    HotelEntity toEntity(HotelRq hotelRq);

}
