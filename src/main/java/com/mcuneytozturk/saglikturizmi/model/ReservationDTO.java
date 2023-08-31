package com.mcuneytozturk.saglikturizmi.model;


import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {
    private RoomDTO room;
    private PatientDTO patient;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isPaid = false;
}
