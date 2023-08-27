package com.mcuneytozturk.saglikturizmi.model;


import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO extends BaseDTO {
    private RoomDTO room;
    private PatientDTO patient;
    private LocalDateTime reservationDate;
    private boolean isPaid = false;
}
