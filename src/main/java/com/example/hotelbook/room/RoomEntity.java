package com.example.hotelbook.room;


import com.example.hotelbook.hotel.HotelEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "room")
public class RoomEntity {

    public RoomEntity(HotelEntity hotel, RoomType roomType, double price, int roomQuantity) {
        this.hotel = hotel;
        this.roomType = roomType;
        this.price = price;
        this.roomQuantity = roomQuantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private double price;
    @Column(name = "room_quantity")
    private int roomQuantity;

}
