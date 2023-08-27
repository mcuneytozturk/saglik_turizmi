package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDTO extends BaseDTO {
    private DoctorDTO doctor;
    private PatientDTO patient;
    private LocalDateTime reservationDate;
    private boolean isAccepted = false;
}
