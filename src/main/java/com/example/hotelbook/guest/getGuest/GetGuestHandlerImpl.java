package com.example.hotelbook.guest.getGuest;

import com.example.hotelbook.guest.GuestRepository;
import com.example.hotelbook.guest.dto.GuestRs;
import com.example.hotelbook.guest.mapper.GuestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetGuestHandlerImpl implements GetGuestHandler {

    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Override
    public GuestRs findById(Long id) {
        return guestMapper.toDto(guestRepository.findById(id).orElseThrow());
    }

    @Override
    public List<GuestRs> findAll() {
        return guestRepository.findAll()
                .stream()
                .map(guestMapper::toDto)
                .collect(Collectors.toList());
    }
}
