package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.model.RoomDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements BaseMapper<RoomDTO, RoomEntity> {

    private final HotelMapper hotelMapper;

    public RoomMapper(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setCapacity(entity.getCapacity());
        dto.setCheckInDate(entity.getCheckInDate());
        dto.setCheckOutDate(entity.getCheckOutDate());
        dto.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        return dto;
    }
    @Override
    public RoomEntity dtoToEntity(RoomDTO dto){
        RoomEntity entity = new RoomEntity();
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));

        return entity;
    }

    @Override
    public List<RoomDTO> entityListToDTOList(List<RoomEntity> entityList) {
        List<RoomDTO> dtoList = new ArrayList<>();

        for (RoomEntity entity: entityList){
            dtoList.add(entityToDTO(entity));
        }

        return dtoList;
    }

    @Override
    public List<RoomEntity> dtoListTOEntityList(List<RoomDTO> dtoList) {

        List<RoomEntity> entityList = new ArrayList<>();

        for (RoomDTO dto: dtoList){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }
    @Override
    public RoomEntity dtoToExistEntity(RoomEntity entity, RoomDTO dto) {
        entity.setId(dto.getId());
        entity.setCapacity(dto.getCapacity());
        entity.setCheckInDate(dto.getCheckInDate());
        entity.setCheckOutDate(dto.getCheckOutDate());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));

        return entity;
    }

}
