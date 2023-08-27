package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rooms")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "room_uuid"
        )
)
@Data
public class RoomEntity extends BaseEntity {
        @Column
        private int capacity;
        @Column
        private LocalDate checkInDate;
        @Column
        private LocalDate checkOutDate;
        @ManyToOne
        private HotelEntity hotel;
        @OneToMany
        private List<ReservationEntity> reservations;
}
