package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "flighs")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "flight_uuid"
        )
)
@Data
public class FlightEntity extends BaseEntity {
        @Column
        private String flightNo;
        @Column
        private LocalDateTime departureTime;
        @Column
        private LocalDateTime arrivalTime;
        @Column
        private String departureLocation;
        @Column
        private String arrivalLocation;
        @Column
        private int capacity;
}
