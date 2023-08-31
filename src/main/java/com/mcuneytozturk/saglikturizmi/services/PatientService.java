package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.PatientRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.PatientRoleRepository;
import com.mcuneytozturk.saglikturizmi.mapper.PatientMapper;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PatientService extends BaseService<PatientEntity, PatientDTO, PatientMapper, PatientRepository> {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PatientRoleRepository patientRoleRepository;

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

    public void savePatientByRole(PatientEntity patient){
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        Set<PatientRoleEntity> roles = new HashSet<>();
        roles.add(patientRoleRepository.findByName("user").get());
        patient.setRoles(roles);
        patientRepository.save(patient);
    }
}
