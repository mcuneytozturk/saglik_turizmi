package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper implements BaseMapper<DoctorDTO, DoctorEntity> {


    private final HospitalMapper hospitalMapper;
    private final PatientMapper patientMapper;
    private final ReportMapper reportMapper;
    private final AppointmentMapper appointmentMapper;

    public DoctorMapper(@Lazy HospitalMapper hospitalMapper, PatientMapper patientMapper, @Lazy ReportMapper reportMapper, AppointmentMapper appointmentMapper) {
        this.hospitalMapper = hospitalMapper;
        this.patientMapper = patientMapper;
        this.reportMapper = reportMapper;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public DoctorDTO entityToDTO(DoctorEntity entity) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        dto.setProfession(entity.getProfession());
        dto.setHospital(hospitalMapper.entityToDTO(entity.getHospital()));
        dto.setPatients(patientMapper.entityListToDTOList(entity.getPatients()));
        dto.setReports(reportMapper.entityListToDTOList(entity.getReports()));
        dto.setAppointments(appointmentMapper.entityListToDTOList(entity.getAppointments()));
        return dto;
    }

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        DoctorEntity entity = new DoctorEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setProfession(dto.getProfession());
        entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        entity.setPatients(patientMapper.dtoListTOEntityList(dto.getPatients()));
        entity.setReports(reportMapper.dtoListTOEntityList(dto.getReports()));
        entity.setAppointments(appointmentMapper.dtoListTOEntityList(dto.getAppointments()));

        return entity;
    }

    @Override
    public List<DoctorDTO> entityListToDTOList(List<DoctorEntity> entityList) {
        List<DoctorDTO> dtoList = new ArrayList<>();

        for (DoctorEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<DoctorEntity> dtoListTOEntityList(List<DoctorDTO> dtoList) {
        List<DoctorEntity> entities = new ArrayList<>();

        for (DoctorDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public DoctorEntity dtoToExistEntity(DoctorEntity entity, DoctorDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setProfession(dto.getProfession());
        entity.setHospital(hospitalMapper.dtoToEntity(dto.getHospital()));
        entity.setPatients(patientMapper.dtoListTOEntityList(dto.getPatients()));
        entity.setReports(reportMapper.dtoListTOEntityList(dto.getReports()));
        entity.setAppointments(appointmentMapper.dtoListTOEntityList(dto.getAppointments()));

        return entity;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> entities) {
        PageDTO<DoctorDTO> pageDTO = new PageDTO<>();
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

