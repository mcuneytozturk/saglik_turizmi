package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.FlightEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.FlightRepository;
import com.mcuneytozturk.saglikturizmi.mapper.FlightMapper;
import com.mcuneytozturk.saglikturizmi.model.FlightDTO;
import com.mcuneytozturk.saglikturizmi.services.FlightService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController extends BaseController<FlightEntity, FlightDTO, FlightRepository, FlightMapper, FlightService>{

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @Override
    protected FlightService getService() {
        return flightService;

    }
}
