package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.PatientRepository;
import com.mcuneytozturk.saglikturizmi.mapper.PatientMapper;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientMapper, PatientRepository> {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    @Override
    protected PatientMapper getMapper() {
        return patientMapper;
    }

    @Override
    protected PatientRepository getRepository() {
        return patientRepository;
    }
}
