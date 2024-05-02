package com.example.hotelbook.guest;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "guest")
public class GuestEntity {

    public GuestEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

}
