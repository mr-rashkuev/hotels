package com.example.hotelbook.guest.createguest;

import com.example.hotelbook.guest.GuestEntity;
import com.example.hotelbook.guest.GuestRepository;
import com.example.hotelbook.guest.dto.GuestRq;
import com.example.hotelbook.guest.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGuestHandlerImpl implements CreateGuestHandler {

    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Override
    public void addGuest(GuestRq guestRq) {
        GuestEntity guest = guestMapper.toEntity(guestRq);
        guestRepository.save(guest);
    }
}
