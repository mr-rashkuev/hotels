package com.example.hotelbook.hotel.dto;



public record HotelRs(

        Long id,
        String name,
        AddressDto address) {
    public record AddressDto(
            String city,
            String street,
            int houseNumber
    ) {
    }
}




