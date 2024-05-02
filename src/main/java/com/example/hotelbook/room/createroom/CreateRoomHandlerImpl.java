package com.example.hotelbook.room.createroom;

import com.example.hotelbook.hotel.HotelEntity;
import com.example.hotelbook.hotel.HotelRepository;
import com.example.hotelbook.room.RoomEntity;
import com.example.hotelbook.room.RoomRepository;
import com.example.hotelbook.room.dto.RoomRq;
import com.example.hotelbook.room.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRoomHandlerImpl implements CreateRoomHandler {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final RoomMapper roomMapper;


    @Override
    public void addRoom(RoomRq roomRq) {
        RoomEntity room = roomMapper.toEntity(roomRq);
        HotelEntity hotel = hotelRepository.findById(roomRq.hotel()).orElseThrow();
        room.setHotel(hotel);
        roomRepository.save(room);
    }


}
