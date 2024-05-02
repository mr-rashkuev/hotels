package com.example.hotelbook.hotel;


import com.example.hotelbook.room.RoomEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "hotel")
public class HotelEntity {

    public HotelEntity(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany
    private List<RoomEntity> rooms;

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {

        private String city;
        private String street;
        @Column(name = "house_number")
        private int houseNumber;

    }
}



