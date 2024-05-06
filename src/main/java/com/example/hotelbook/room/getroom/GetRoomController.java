package com.example.hotelbook.room.getroom;

import com.example.hotelbook.room.dto.FilterByPriceAndCity;
import com.example.hotelbook.room.dto.LocationAndDate;
import com.example.hotelbook.room.dto.RoomAvailableRs;
import com.example.hotelbook.room.dto.RoomRs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms/")
@RequiredArgsConstructor
public class GetRoomController {

    private final GetRoomHandler getRoomHandler;

    @GetMapping("{id}")
    public RoomRs getById(@PathVariable Long id){
        return getRoomHandler.findById(id);
    }

    @GetMapping
    public List<RoomRs> getRooms(){
        return getRoomHandler.findAll();
    }

    @GetMapping("free")
    public List<RoomAvailableRs> getBookedRooms(@RequestBody LocationAndDate locationAndDate){
        return getRoomHandler.getAvailableRooms(locationAndDate);
    }

    @GetMapping("/city")
    public List<RoomAvailableRs> getByCity(@RequestParam String city){
        return getRoomHandler.getRoomsByCity(city);
    }

    @GetMapping("/price")
    public List<RoomRs> getByPriceFilter(@RequestBody FilterByPriceAndCity filter){
        return getRoomHandler.getByPriceAndCity(filter);
    }
}
