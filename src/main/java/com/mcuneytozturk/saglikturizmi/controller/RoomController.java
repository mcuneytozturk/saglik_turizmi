package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.RoomRepository;
import com.mcuneytozturk.saglikturizmi.mapper.RoomMapper;
import com.mcuneytozturk.saglikturizmi.model.RoomDTO;
import com.mcuneytozturk.saglikturizmi.services.RoomService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends BaseController<RoomEntity, RoomDTO, RoomRepository, RoomMapper, RoomService> {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @Override
    protected RoomService getService() {
        return roomService;
    }
}
