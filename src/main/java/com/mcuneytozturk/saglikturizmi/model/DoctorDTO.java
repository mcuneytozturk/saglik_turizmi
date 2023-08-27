package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class DoctorDTO extends BaseDTO {
    private String name;
    private String profession;
    private List<PatientDTO> patients;
    private HospitalDTO hospital;
    private List<ReportDTO> reports;
    private List<AppointmentDTO> appointments;

}
