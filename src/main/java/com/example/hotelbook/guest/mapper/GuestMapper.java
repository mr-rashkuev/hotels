package com.example.hotelbook.guest.mapper;

import com.example.hotelbook.guest.GuestEntity;
import com.example.hotelbook.guest.dto.GuestRq;
import com.example.hotelbook.guest.dto.GuestRs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper {

    GuestRs toDto(GuestEntity guest);

    GuestEntity toEntity(GuestRq guestRq);
}
