package com.example.hotelbook.room.get_room;

import com.example.hotelbook.room.RoomRepository;
import com.example.hotelbook.room.dto.BookedRoom;
import com.example.hotelbook.room.dto.LocationAndDate;
import com.example.hotelbook.room.dto.RoomAvailableRs;
import com.example.hotelbook.room.dto.RoomRs;
import com.example.hotelbook.room.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class GetRoomHandlerImpl implements GetRoomHandler {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomRs findById(Long id) {
        return roomMapper.toDto(roomRepository.findById(id).orElseThrow());
    }

    @Override
    public List<RoomRs> findAll() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<BookedRoom> getBookedRooms(LocationAndDate locationAndDate) {
        return roomRepository.findBookedRooms(locationAndDate.city(), locationAndDate.checkIn(), locationAndDate.checkOut());
    }

    @Override
    public List<RoomAvailableRs> getRoomsByCity(String city) {
        return roomRepository.findRoomsByCity(city)
                .stream()
                .map(roomMapper::toRoomAvailableRs)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomAvailableRs> getAvailableRooms(LocationAndDate locationAndDate) {
        Map<Long, Long> bookedRooms = getBookedRooms(locationAndDate).stream().collect(toMap(BookedRoom::getId, BookedRoom::getBookedCount));
        List<RoomAvailableRs> roomsByCity = getRoomsByCity(locationAndDate.city());
        List<RoomAvailableRs> roomForBooking = new ArrayList<>();
        for (RoomAvailableRs roomAvailableRs : roomsByCity) {
            RoomAvailableRs rs;
                if (bookedRooms.containsKey(roomAvailableRs.id())) {
                    if (roomAvailableRs.roomQuantity() - bookedRooms.get(roomAvailableRs.id()) > 0) {
                        rs = new RoomAvailableRs(
                                roomAvailableRs.id(),
                                roomAvailableRs.hotel(),
                                roomAvailableRs.roomType(),
                                roomAvailableRs.price(),
                                (int) (roomAvailableRs.roomQuantity() - bookedRooms.get(roomAvailableRs.id())));
                        roomForBooking.add(rs);
                    }
                }else{ rs = new RoomAvailableRs(
                        roomAvailableRs.id(),
                        roomAvailableRs.hotel(),
                        roomAvailableRs.roomType(),
                        roomAvailableRs.price(),
                        roomAvailableRs.roomQuantity());
                roomForBooking.add(rs);}
            }
        return roomForBooking;
    }
}
