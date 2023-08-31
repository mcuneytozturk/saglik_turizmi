package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "appointment")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "appointment_uuid"
        )
)
@Data
public class AppointmentEntity extends BaseEntity {
    @ManyToOne
    private DoctorEntity doctor;
    @OneToOne
    private PatientEntity patient;
    @Column
    private LocalDateTime reservationDate;
    @Column
    private boolean accepted = false;
}
