package com.example.hotelbook.hotel.addHotel;


import com.example.hotelbook.hotel.dto.HotelRq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels/")
@RequiredArgsConstructor
public class CreateHotelController {

    private final CreateHotelHandler createHotelHandler;

    @PostMapping
    public void addHotel(@RequestBody HotelRq hotelRq){
        createHotelHandler.addHotel(hotelRq);
    }
}
