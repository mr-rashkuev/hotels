package com.example.hotelbook.guest.createguest;


import com.example.hotelbook.guest.dto.GuestRq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests/")
@RequiredArgsConstructor
public class CreateGuestController {

    private final CreateGuestHandler createGuestHandler;

    @PostMapping
    public void addGuest(@RequestBody GuestRq guestRq){
        createGuestHandler.addGuest(guestRq);
    }
}
