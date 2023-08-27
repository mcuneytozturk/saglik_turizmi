package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.HotelEntity;
import com.mcuneytozturk.saglikturizmi.model.HotelDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelMapper implements BaseMapper<HotelDTO, HotelEntity> {

    private RoomMapper roomMapper;

    public HotelMapper(RoomMapper roomMapper) {
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
}
