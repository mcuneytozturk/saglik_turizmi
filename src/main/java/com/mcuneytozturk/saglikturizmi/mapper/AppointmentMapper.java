package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.model.AdminDTO;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper implements BaseMapper<AppointmentDTO, AppointmentEntity> {
    @Autowired
            @Lazy
    DoctorMapper doctorMapper;

    @Autowired
    PatientMapper patientMapper;


    @Override
    public AppointmentDTO entityToDTO(AppointmentEntity entity) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        dto.setAccepted(entity.isAccepted());
        dto.setReservationDate(entity.getReservationDate());

        return dto;
    }

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setAccepted(dto.isAccepted());
        entity.setReservationDate(dto.getReservationDate());

        return entity;
    }

    @Override
    public List<AppointmentDTO> entityListToDTOList(List<AppointmentEntity> entityList) {
        List<AppointmentDTO> dtoList = new ArrayList<>();

        for (AppointmentEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<AppointmentEntity> dtoListTOEntityList(List<AppointmentDTO> dtoList) {
        List<AppointmentEntity> entities = new ArrayList<>();

        for (AppointmentDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public AppointmentEntity dtoToExistEntity(AppointmentEntity entity, AppointmentDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setAccepted(dto.isAccepted());
        entity.setReservationDate(dto.getReservationDate());

        return entity;
    }

    @Override
    public PageDTO<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> entities) {
        PageDTO<AppointmentDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotalPages(entities.getTotalPages());
        pageDTO.setSort(entities.getSort());
        pageDTO.setNumberOfElements(entities.getNumberOfElements());
        pageDTO.setSize(entities.getSize());
        pageDTO.setContent(entityListToDTOList(entities.getContent()));
        pageDTO.setTotalElements(entities.getTotalElements());
        pageDTO.setNumber(entities.getNumber());


        return pageDTO;
    }
}

