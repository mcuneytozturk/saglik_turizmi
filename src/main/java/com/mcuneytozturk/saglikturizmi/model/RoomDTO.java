package com.mcuneytozturk.saglikturizmi.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomDTO{
    private Long id;
    private int capacity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private HotelDTO hotel;
}
