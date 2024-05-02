package com.example.hotelbook.hotel.getHotel;


import com.example.hotelbook.hotel.dto.HotelRs;

import java.util.List;

public interface GetHotelHandler {

    HotelRs findById(Long id);

    List<HotelRs> findAll();

}
