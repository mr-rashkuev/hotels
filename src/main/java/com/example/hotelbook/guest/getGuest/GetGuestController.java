package com.example.hotelbook.guest.getGuest;

import com.example.hotelbook.guest.dto.GuestRs;
import com.example.hotelbook.guest.getGuest.GetGuestHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests/")
@RequiredArgsConstructor
public class GetGuestController {

    private final GetGuestHandler getGuestHandler;

    @GetMapping("{id}")
    public GuestRs getById(@PathVariable Long id){
        return getGuestHandler.findById(id);
    }

    @GetMapping
    public List<GuestRs> getAllGuests(){
        return getGuestHandler.findAll();
    }
}
