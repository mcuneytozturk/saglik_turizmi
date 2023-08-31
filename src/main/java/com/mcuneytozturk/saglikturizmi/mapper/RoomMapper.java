package com.mcuneytozturk.saglikturizmi.mapper;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.PageDTO;
import com.mcuneytozturk.saglikturizmi.model.RoomDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomMapper implements BaseMapper<RoomDTO, RoomEntity> {

    private final ReservationMapper reservationMapper;
    private final HotelMapper hotelMapper;

    public RoomMapper(HotelMapper hotelMapper, @Lazy ReservationMapper reservationMapper) {
        this.hotelMapper = hotelMapper;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public RoomDTO entityToDTO(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setRoomNumber(entity.getRoomNumber());
        dto.setRoomType(entity.getRoomType());
        dto.setHotel(hotelMapper.entityToDTO(entity.getHotel()));
        dto.setReservations(reservationMapper.entityListToDTOList(entity.getReservations()));
        return dto;
    }
    @Override
    public RoomEntity dtoToEntity(RoomDTO dto){
        RoomEntity entity = new RoomEntity();
        entity.setId(dto.getId());
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setRoomType(dto.getRoomType());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));
        entity.setReservations(reservationMapper.dtoListTOEntityList(dto.getReservations()));

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
        entity.setRoomType(dto.getRoomType());
        entity.setRoomNumber(dto.getRoomNumber());
        entity.setHotel(hotelMapper.dtoToEntity(dto.getHotel()));
        entity.setReservations(reservationMapper.dtoListTOEntityList(dto.getReservations()));

        return entity;
    }

    @Override
    public PageDTO<RoomDTO> pageEntityToPageDTO(Page<RoomEntity> entities) {
        PageDTO<RoomDTO> pageDTO = new PageDTO<>();
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
