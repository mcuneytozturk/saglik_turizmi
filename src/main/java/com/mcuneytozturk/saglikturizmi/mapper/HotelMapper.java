package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.HotelEntity;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.HotelDTO;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements BaseMapper<HotelDTO, HotelEntity> {

    private RoomMapper roomMapper;

    public HotelMapper(@Lazy RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public HotelDTO entityToDTO(HotelEntity entity) {
        HotelDTO dto = new HotelDTO();
        dto.setId(entity.getId());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUuid(entity.getUuid());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCity(entity.getCity());
        dto.setName(entity.getName());
        dto.setRooms(roomMapper.entityListToDTOList(entity.getRooms()));
        return dto;
    }

    @Override
    public HotelEntity dtoToEntity(HotelDTO dto) {
        HotelEntity entity = new HotelEntity();
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setRooms(roomMapper.dtoListTOEntityList(dto.getRooms()));

        return entity;
    }

    @Override
    public List<HotelDTO> entityListToDTOList(List<HotelEntity> entityList) {
        List<HotelDTO> dtoList = new ArrayList<>();

        for (HotelEntity entity : entityList) {
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<HotelEntity> dtoListTOEntityList(List<HotelDTO> dtoList) {
        List<HotelEntity> entities = new ArrayList<>();

        for (HotelDTO dto: dtoList){
            entities.add(dtoToEntity(dto));
        }

        return entities;
    }

    @Override
    public HotelEntity dtoToExistEntity(HotelEntity entity, HotelDTO dto) {
        entity.setId(dto.getId());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUuid(dto.getUuid());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCity(dto.getCity());
        entity.setName(dto.getName());
        entity.setRooms(roomMapper.dtoListTOEntityList(dto.getRooms()));

        return entity;
    }
    @Override
    public PageDTO<HotelDTO> pageEntityToPageDTO(Page<HotelEntity> entities) {
        PageDTO<HotelDTO> pageDTO = new PageDTO<>();
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
