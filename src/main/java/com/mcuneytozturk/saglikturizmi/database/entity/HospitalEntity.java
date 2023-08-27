package com.mcuneytozturk.saglikturizmi.database.entity;


import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "hospitals")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "hospital_uuid"
        )
)
@Data
public class HospitalEntity extends BaseEntity {
        @Column
        private String name;
        @Column
        private String city;
        @OneToMany
        private List<DoctorEntity> doctors;
        @OneToMany
        private List<PatientEntity> patients;


}
