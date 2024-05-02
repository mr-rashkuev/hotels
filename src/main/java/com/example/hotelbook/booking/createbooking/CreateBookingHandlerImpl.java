package com.example.hotelbook.booking.createbooking;

import com.example.hotelbook.booking.BookingEntity;
import com.example.hotelbook.booking.BookingRepository;
import com.example.hotelbook.booking.dto.BookingRq;
import com.example.hotelbook.guest.GuestEntity;
import com.example.hotelbook.guest.GuestRepository;
import com.example.hotelbook.room.RoomEntity;
import com.example.hotelbook.room.RoomRepository;
import com.example.hotelbook.room.dto.LocationAndDate;
import com.example.hotelbook.room.getroom.GetRoomHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookingHandlerImpl implements CreateBookingHandler {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final GetRoomHandler getRoomHandler;

    @Override
    public void addBooking(BookingRq bookingRq) {
        RoomEntity room = roomRepository.findById(bookingRq.room()).orElseThrow();
        GuestEntity guest = guestRepository.findById(bookingRq.guest()).orElseThrow();
        if (bookingRq.checkIn().isAfter(bookingRq.checkOut())) {
            throw new IllegalArgumentException("Дата начала брони не может быть позднее даты окончания");
        } else {
            BookingEntity booking = BookingEntity.builder()
                    .room(room)
                    .guest(guest)
                    .checkIn(bookingRq.checkIn())
                    .checkOut(bookingRq.checkOut()).build();
            bookingRepository.save(booking);
        }
    }

    public void payForBooking(){

    }
    public void somethingHappen(LocationAndDate locationAndDate){
        getRoomHandler.getBookedRooms(locationAndDate);
    }


}
