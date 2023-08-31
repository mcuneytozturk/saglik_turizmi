package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reports")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "report_uuid"
        )
)
@Data
public class ReportEntity extends BaseEntity {
        @ManyToOne
        private PatientEntity patient;

        @ManyToOne
        private DoctorEntity doctor;

        @Column
        private String detail;
}
