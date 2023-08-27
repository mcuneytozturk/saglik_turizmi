package com.mcuneytozturk.saglikturizmi.model;

import com.mcuneytozturk.saglikturizmi.util.BaseDTO;
import lombok.Data;

@Data
public class ReportDTO extends BaseDTO {
    private PatientDTO patient;
    private DoctorDTO doctor;
    private String detail;
}
