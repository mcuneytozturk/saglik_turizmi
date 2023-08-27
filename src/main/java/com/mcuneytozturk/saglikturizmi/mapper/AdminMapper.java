package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.model.AdminDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMapper implements BaseMapper<AdminDTO, AdminEntity> {
    @Override
    public AdminDTO entityToDTO(AdminEntity entity) {
        AdminDTO dto = new AdminDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setAdminName(entity.getAdminName());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    @Override
    public AdminEntity dtoToEntity(AdminDTO dto) {
        AdminEntity entity = new AdminEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAdminName(dto.getAdminName());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

    @Override
    public List<AdminDTO> entityListToDTOList(List<AdminEntity> adminEntities) {
        List<AdminDTO> dtoList = new ArrayList<>();

        for (AdminEntity entity: adminEntities){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<AdminEntity> dtoListTOEntityList(List<AdminDTO> dtoList) {

        List<AdminEntity> entityList = new ArrayList<>();

        for (AdminDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public AdminEntity dtoToExistEntity(AdminEntity entity, AdminDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setAdminName(dto.getAdminName());
        entity.setPassword(dto.getPassword());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());

        return entity;
    }
}
