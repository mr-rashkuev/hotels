package com.example.hotelbook.guest.getGuest;

import com.example.hotelbook.guest.dto.GuestRs;

import java.util.List;

public interface GetGuestHandler {

    GuestRs findById(Long id);

    List<GuestRs> findAll();
}
