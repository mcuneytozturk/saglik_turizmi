package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatientMapper implements BaseMapper<PatientDTO, PatientEntity> {

    @Override
    public PatientDTO entityToDTO(PatientEntity entity) {
        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setPhotoLink(entity.getPhotoLink());
        return dto;
    }

    @Override
    public PatientEntity dtoToEntity(PatientDTO dto) {
        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhotoLink(dto.getPhotoLink());
        return entity;
    }

    @Override
    public List<PatientDTO> entityListToDTOList(List<PatientEntity> entityList) {
        List<PatientDTO> dtoList = new ArrayList<>();

        for (PatientEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<PatientEntity> dtoListTOEntityList(List<PatientDTO> dtoList) {

        List<PatientEntity> entityList = new ArrayList<>();

        for (PatientDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public PatientEntity dtoToExistEntity(PatientEntity entity, PatientDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setAge(dto.getAge());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setPhotoLink(dto.getPhotoLink());

        return entity;
    }
}
