package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.HospitalEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.HospitalRepository;
import com.mcuneytozturk.saglikturizmi.mapper.HospitalMapper;
import com.mcuneytozturk.saglikturizmi.model.HospitalDTO;
import com.mcuneytozturk.saglikturizmi.services.HospitalService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController<HospitalEntity, HospitalDTO, HospitalRepository, HospitalMapper, HospitalService> {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    protected HospitalService getService() {
        return hospitalService;
    }
}
