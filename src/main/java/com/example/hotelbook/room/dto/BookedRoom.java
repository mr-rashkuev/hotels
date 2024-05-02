package com.example.hotelbook.room.dto;

import com.example.hotelbook.room.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    private Long id;
    private RoomType type;
    private Long bookedRoomsCount;

}
