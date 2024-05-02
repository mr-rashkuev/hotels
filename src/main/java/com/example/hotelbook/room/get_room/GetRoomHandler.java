package com.example.hotelbook.room.get_room;

import com.example.hotelbook.room.dto.BookedRoom;
import com.example.hotelbook.room.dto.LocationAndDate;
import com.example.hotelbook.room.dto.RoomAvailableRs;
import com.example.hotelbook.room.dto.RoomRs;

import java.util.List;

public interface GetRoomHandler {

    RoomRs findById(Long id);

    List<RoomRs> findAll();

    List<BookedRoom> getBookedRooms(LocationAndDate locationAndDate);

    List<RoomAvailableRs> getRoomsByCity(String city);

    List<RoomAvailableRs> getAvailableRooms(LocationAndDate locationAndDate);

}
