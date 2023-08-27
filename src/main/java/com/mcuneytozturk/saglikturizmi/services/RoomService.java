package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.RoomRepository;
import com.mcuneytozturk.saglikturizmi.mapper.RoomMapper;
import com.mcuneytozturk.saglikturizmi.model.RoomDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService<RoomEntity, RoomDTO, RoomMapper, RoomRepository> {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    protected RoomMapper getMapper() {
        return roomMapper;
    }

    @Override
    protected RoomRepository getRepository() {
        return roomRepository;
    }
}
