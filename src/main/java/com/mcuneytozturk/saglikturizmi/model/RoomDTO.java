package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RoomDTO extends BaseDTO {
    private int roomNumber;
    private String roomType;
    private HotelDTO hotel;
    private List<ReservationDTO> reservations;
}
