package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "hotels")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hotel_uuid"
        )
)
@Data
public class HotelEntity extends BaseEntity {
        @Column
        private String name;
        @Column
        private String city;
        @OneToMany(fetch = FetchType.LAZY)
        private List<RoomEntity> rooms;
}
