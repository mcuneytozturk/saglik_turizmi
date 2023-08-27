package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.HospitalEntity;
import com.mcuneytozturk.saglikturizmi.model.HospitalDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HospitalMapper implements BaseMapper<HospitalDTO, HospitalEntity> {

    private final DoctorMapper doctorMapper;

    private final PatientMapper patientMapper;

    public HospitalMapper(DoctorMapper doctorMapper, PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public HospitalDTO entityToDTO(HospitalEntity entity) {
        HospitalDTO dto = new HospitalDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setDoctors(doctorMapper.entityListToDTOList(entity.getDoctors()));
        dto.setPatients(patientMapper.entityListToDTOList(entity.getPatients()));
        return dto;
    }

    @Override
    public HospitalEntity dtoToEntity(HospitalDTO dto) {
        HospitalEntity entity = new HospitalEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setDoctors(doctorMapper.dtoListTOEntityList(dto.getDoctors()));
        entity.setPatients(patientMapper.dtoListTOEntityList(dto.getPatients()));
        return entity;
    }

    @Override
    public List<HospitalDTO> entityListToDTOList(List<HospitalEntity> entityList) {
        List<HospitalDTO> dtoList = new ArrayList<>();

        for (HospitalEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<HospitalEntity> dtoListTOEntityList(List<HospitalDTO> dtoList) {
        List<HospitalEntity> entities = new ArrayList<>();

        for (HospitalDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public HospitalEntity dtoToExistEntity(HospitalEntity entity, HospitalDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setDoctors(doctorMapper.dtoListTOEntityList(dto.getDoctors()));

        return entity;
    }
}
