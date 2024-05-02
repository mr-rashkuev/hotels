package com.example.hotelbook.hotel.getHotel;

import com.example.hotelbook.hotel.dto.HotelRs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotels/")
public class GetHotelController {

    private final GetHotelHandler getHotelHandler;

    @GetMapping("{id}")
    public HotelRs getById(@PathVariable Long id){
        return getHotelHandler.findById(id);
    }

    @GetMapping
    public List<HotelRs> getHotels(){
        return getHotelHandler.findAll();
    }
}
