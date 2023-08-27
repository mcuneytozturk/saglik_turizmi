package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.HospitalEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.HospitalRepository;
import com.mcuneytozturk.saglikturizmi.mapper.HospitalMapper;
import com.mcuneytozturk.saglikturizmi.model.HospitalDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HospitalService extends BaseService<HospitalEntity, HospitalDTO, HospitalMapper, HospitalRepository> {
    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository) {
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    protected HospitalMapper getMapper() {
        return hospitalMapper;
    }

    @Override
    protected HospitalRepository getRepository() {
        return hospitalRepository;
    }
}
