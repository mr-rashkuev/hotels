package com.example.hotelbook.room.create_room;


import com.example.hotelbook.room.dto.RoomRq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms/")
public class CreateRoomController {

    private final CreateRoomHandler createRoomHandler;

    @PostMapping
    public void addRoom(@RequestBody RoomRq roomRq){
        createRoomHandler.addRoom(roomRq);
    }
}
