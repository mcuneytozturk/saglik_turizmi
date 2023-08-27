package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.PatientRepository;
import com.mcuneytozturk.saglikturizmi.mapper.PatientMapper;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.services.PatientService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController extends BaseController<PatientEntity, PatientDTO, PatientRepository, PatientMapper, PatientService> {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @Override
    protected PatientService getService() {
        return patientService;
    }
}
