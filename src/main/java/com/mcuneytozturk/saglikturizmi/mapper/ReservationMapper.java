package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.ReportEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.ReservationEntity;
import com.mcuneytozturk.saglikturizmi.model.ReportDTO;
import com.mcuneytozturk.saglikturizmi.model.ReservationDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper implements BaseMapper<ReservationDTO, ReservationEntity> {
    private final PatientMapper patientMapper;
    private final RoomMapper roomMapper;

    public ReservationMapper(PatientMapper patientMapper, RoomMapper roomMapper) {
        this.patientMapper = patientMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public ReservationDTO entityToDTO(ReservationEntity entity) {
        ReservationDTO dto = new ReservationDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        dto.setRoom(roomMapper.entityToDTO(entity.getRoom()));
        dto.setPaid(entity.isPaid());

        return dto;
    }

    @Override
    public ReservationEntity dtoToEntity(ReservationDTO dto) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        entity.setPaid(dto.isPaid());

        return entity;
    }

    @Override
    public List<ReservationDTO> entityListToDTOList(List<ReservationEntity> entityList) {
        List<ReservationDTO> dtoList = new ArrayList<>();

        for (ReservationEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<ReservationEntity> dtoListTOEntityList(List<ReservationDTO> dtoList) {
        List<ReservationEntity> entityList = new ArrayList<>();

        for (ReservationDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public ReservationEntity dtoToExistEntity(ReservationEntity entity, ReservationDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setRoom(roomMapper.dtoToEntity(dto.getRoom()));
        entity.setPaid(dto.isPaid());

        return entity;
    }
}
