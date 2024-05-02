package com.example.hotelbook.room.mapper;

import com.example.hotelbook.room.RoomEntity;
import com.example.hotelbook.room.dto.RoomAvailableRs;
import com.example.hotelbook.room.dto.RoomRq;
import com.example.hotelbook.room.dto.RoomRs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "hotel", source = "room.hotel.name")
    RoomRs toDto(RoomEntity room);

    @Mapping(target = "hotel", ignore = true)
    RoomEntity toEntity(RoomRq roomRq);


    @Mapping(target = "hotel", source = "room.hotel.name")
    RoomAvailableRs toRoomAvailableRs(RoomEntity room);
}
