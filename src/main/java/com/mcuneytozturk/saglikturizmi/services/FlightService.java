package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.FlightEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.FlightRepository;
import com.mcuneytozturk.saglikturizmi.mapper.FlightMapper;
import com.mcuneytozturk.saglikturizmi.model.FlightDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends BaseService<FlightEntity, FlightDTO, FlightMapper, FlightRepository> {

    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;

    public FlightService(FlightMapper flightMapper, FlightRepository flightRepository) {
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
    }

    @Override
    protected FlightMapper getMapper() {
        return flightMapper;
    }

    @Override
    protected FlightRepository getRepository() {
        return flightRepository;
    }
}
