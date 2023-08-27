package com.mcuneytozturk.saglikturizmi.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rooms")
@Data
public class RoomEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        @Column
        private int capacity;
        @Column
        private LocalDate checkInDate;
        @Column
        private LocalDate checkOutDate;
        @ManyToOne
        private HotelEntity hotel;
}
