package com.example.hotelbook.room.getroom;

import com.example.hotelbook.room.dto.*;

import java.util.List;

public interface GetRoomHandler {

    RoomRs findById(Long id);

    List<RoomRs> findAll();

    List<BookedRoom> getBookedRooms(LocationAndDate locationAndDate);

    List<RoomAvailableRs> getRoomsByCity(String city);

    List<RoomAvailableRs> getAvailableRooms(LocationAndDate locationAndDate);

    List<RoomRs> getByPriceAndCity(FilterByPriceAndCity filter);

}
