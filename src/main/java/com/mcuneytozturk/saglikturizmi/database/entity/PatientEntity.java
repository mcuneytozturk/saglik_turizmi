package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "patients")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "patient_uuid"
        )
)
@Data
public class PatientEntity extends BaseEntity {
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int age;
    @Column
    private String email;
    @Column
    private String password;
    @OneToOne
    private ReservationEntity reservation;
    @OneToOne
    private AppointmentEntity appointment;
    @OneToMany(fetch = FetchType.LAZY)
    private List<ReportEntity> reports;

    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<PatientRoleEntity> roles;
}
