package com.mcuneytozturk.saglikturizmi.util;

import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseMapper<DTO extends BaseDTO, Entity extends BaseEntity> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity dtoToExistEntity(Entity entity, DTO dto);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

}