package com.mcuneytozturk.saglikturizmi.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcuneytozturk.saglikturizmi.model.HospitalDTO;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "doctors")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "doctor_uuid"
        )
)
@Data
public class DoctorEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String profession;
    @ManyToMany
    private List<PatientEntity> patients;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private HospitalEntity hospital;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<ReportEntity> reports;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<AppointmentEntity> appointments;
}
