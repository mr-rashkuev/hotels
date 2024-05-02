package com.example.hotelbook.booking.mapper;

import com.example.hotelbook.booking.BookingEntity;
import com.example.hotelbook.booking.dto.BookingRq;
import com.example.hotelbook.booking.dto.BookingRs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "room", source = "booking.room.roomType")
    @Mapping(target = "guest", source = "booking.guest.name")
    BookingRs toDto(BookingEntity booking);

    @Mapping(target = "room", ignore = true)
    @Mapping(target = "guest",ignore = true)
    BookingEntity toEntity(BookingRq bookingRq);

}
