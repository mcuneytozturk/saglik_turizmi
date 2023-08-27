package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.DoctorRepository;
import com.mcuneytozturk.saglikturizmi.mapper.DoctorMapper;
import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.services.DoctorService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctor")
public class DoctorController extends BaseController<DoctorEntity, DoctorDTO, DoctorRepository, DoctorMapper, DoctorService> {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    protected DoctorService getService() {
        return doctorService;
    }


}
