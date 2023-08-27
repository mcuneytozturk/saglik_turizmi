package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.DoctorRepository;
import com.mcuneytozturk.saglikturizmi.mapper.DoctorMapper;
import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;

public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorMapper, DoctorRepository> {
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }
    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }
    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }
}
