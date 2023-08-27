package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.FlightEntity;
import com.mcuneytozturk.saglikturizmi.model.FlightDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper implements BaseMapper<FlightDTO, FlightEntity> {
    @Override
    public FlightDTO entityToDTO(FlightEntity entity) {
        FlightDTO dto = new FlightDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFlightNo(entity.getFlightNo());
        dto.setArrivalTime(entity.getArrivalTime());
        dto.setArrivalLocation(entity.getArrivalLocation());
        dto.setDepartureTime(entity.getDepartureTime());
        dto.setDepartureLocation(entity.getDepartureLocation());
        dto.setCapacity(entity.getCapacity());

        return dto;
    }

    @Override
    public FlightEntity dtoToEntity(FlightDTO dto) {
        FlightEntity entity = new FlightEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFlightNo(dto.getFlightNo());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setArrivalLocation(dto.getArrivalLocation());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setDepartureLocation(dto.getDepartureLocation());
        entity.setCapacity(dto.getCapacity());

        return entity;
    }

    @Override
    public List<FlightDTO> entityListToDTOList(List<FlightEntity> entityList) {
        List<FlightDTO> dtoList = new ArrayList<>();

        for (FlightEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<FlightEntity> dtoListTOEntityList(List<FlightDTO> dtoList) {
        List<FlightEntity> entities = new ArrayList<>();

        for (FlightDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public FlightEntity dtoToExistEntity(FlightEntity entity, FlightDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFlightNo(dto.getFlightNo());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setArrivalLocation(dto.getArrivalLocation());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setDepartureLocation(dto.getDepartureLocation());
        entity.setCapacity(dto.getCapacity());

        return entity;
    }
}
