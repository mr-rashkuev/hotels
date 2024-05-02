package com.example.hotelbook.booking;


import com.example.hotelbook.guest.GuestEntity;
import com.example.hotelbook.room.RoomEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class BookingEntity {
    public BookingEntity(GuestEntity guest, RoomEntity room, LocalDate checkIn, LocalDate checkOut) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @Column(name = "check_in")
    private LocalDate checkIn;
    @Column(name = "check_out")
    private LocalDate checkOut;
}
