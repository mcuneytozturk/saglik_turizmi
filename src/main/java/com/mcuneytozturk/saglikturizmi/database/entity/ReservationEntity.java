package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reservations")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "reservation_uuid"
        )
)
@Data
public class ReservationEntity extends BaseEntity {
    @ManyToOne
    private RoomEntity room;
    @OneToOne
    private PatientEntity patient;
    @Column
    private LocalDate checkInDate;
    @Column
    private LocalDate checkOutDate;
    //burda rezervasyonun ödemesinin alınıp alınmadığı tutulur
    @Column
    private boolean paid = false;
}
