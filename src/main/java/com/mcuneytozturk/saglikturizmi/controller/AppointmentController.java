package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AppointmentRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AppointmentMapper;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.services.AppointmentService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("appointment")
public class AppointmentController extends BaseController<AppointmentEntity, AppointmentDTO, AppointmentRepository, AppointmentMapper, AppointmentService> {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @Override
    protected AppointmentService getService() {
        return appointmentService;
    }
}
