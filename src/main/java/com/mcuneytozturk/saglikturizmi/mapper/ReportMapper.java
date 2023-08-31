package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.ReportEntity;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.model.ReportDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportMapper implements BaseMapper<ReportDTO, ReportEntity> {

    private final PatientMapper patientMapper;

    private final DoctorMapper doctorMapper;

    public ReportMapper(PatientMapper patientMapper, DoctorMapper doctorMapper) {
        this.patientMapper = patientMapper;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public ReportDTO entityToDTO(ReportEntity entity) {
        ReportDTO dto = new ReportDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setPatient(patientMapper.entityToDTO(entity.getPatient()));
        dto.setDoctor(doctorMapper.entityToDTO(entity.getDoctor()));
        dto.setDetail(entity.getDetail());
        return dto;
    }

    @Override
    public ReportEntity dtoToEntity(ReportDTO dto) {
        ReportEntity entity = new ReportEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setDetail(dto.getDetail());

        return entity;
    }

    @Override
    public List<ReportDTO> entityListToDTOList(List<ReportEntity> entityList) {
        List<ReportDTO> dtoList = new ArrayList<>();

        for (ReportEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<ReportEntity> dtoListTOEntityList(List<ReportDTO> dtoList) {

        List<ReportEntity> entityList = new ArrayList<>();

        for (ReportDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public ReportEntity dtoToExistEntity(ReportEntity entity, ReportDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setPatient(patientMapper.dtoToEntity(dto.getPatient()));
        entity.setDoctor(doctorMapper.dtoToEntity(dto.getDoctor()));
        entity.setDetail(dto.getDetail());

        return entity;
    }

    @Override
    public PageDTO<ReportDTO> pageEntityToPageDTO(Page<ReportEntity> entities) {
        PageDTO<ReportDTO> pageDTO = new PageDTO<>();
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
