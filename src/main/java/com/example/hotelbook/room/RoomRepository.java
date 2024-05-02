package com.example.hotelbook.room;

import com.example.hotelbook.room.dto.BookedRoom;
import com.example.hotelbook.room.dto.RoomRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("select new com.example.hotelbook.room.dto.BookedRoom(r.id, r.roomType, count(r)) from RoomEntity r join BookingEntity b on r.id=b.room.id " +
            "where b.room.hotel.address.city = ?1 and b.checkIn " +
            "between ?2 and ?3 or b.checkOut between ?2 and ?3" +
            " group by r.id, r.roomType")
    List<BookedRoom> findBookedRooms(String city, LocalDate checkIn, LocalDate checkOut);

    @Query("from RoomEntity r where r.hotel.address.city=?1")
    List<RoomEntity> findRoomsByCity(String city);

}
