package com.example.hotelbook.room.getroom;

import com.example.hotelbook.room.RoomEntity;
import com.example.hotelbook.room.RoomRepository;
import com.example.hotelbook.room.RoomSpecification;
import com.example.hotelbook.room.dto.*;
import com.example.hotelbook.room.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<RoomRs> findAllWithFilters(String city, double price){
        return roomRepository.findAll(
                Specification.where(
                        RoomSpecification.inThatCity(city))
                        .and(RoomSpecification.priceLessThan(price)))
                .stream().map(roomMapper::toDto)
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
        Map<Long, Long> bookedRooms = getBookedRooms(locationAndDate).stream().collect(toMap(BookedRoom::getId, BookedRoom::getBookedRoomsCount));
        List<RoomEntity> roomsByCity = roomRepository.findRoomsByCity(locationAndDate.city());
        List<RoomAvailableRs> roomForBooking = new ArrayList<>();
        for (RoomEntity room : roomsByCity) {
            RoomAvailableRs.RoomAvailableRsBuilder rsBuilder = RoomAvailableRs.builder()
                    .id(room.getId())
                    .hotel(room.getHotel().getName())
                    .roomType(room.getRoomType())
                    .price(room.getPrice());
            if (bookedRooms.containsKey(room.getId())) {
                if (room.getRoomQuantity() - bookedRooms.get(room.getId()) > 0) {
                        RoomAvailableRs rs = rsBuilder.roomQuantity(((int) (room.getRoomQuantity() - bookedRooms.get(room.getId())))).build();
                    roomForBooking.add(rs);
                }
            } else {
                RoomAvailableRs rs = rsBuilder.roomQuantity(room.getRoomQuantity()).build();
                roomForBooking.add(rs);
            }
        }
        return roomForBooking;
    }

    @Override
    public List<RoomRs> getByPriceAndCity(FilterByPriceAndCity filter) {
        return roomRepository.findByPriceAndCity(filter.low(), filter.high(),filter.city()).stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }
}
