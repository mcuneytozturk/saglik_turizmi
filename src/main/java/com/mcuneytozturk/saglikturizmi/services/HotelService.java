package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.HotelEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.HotelRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.RoomRepository;
import com.mcuneytozturk.saglikturizmi.mapper.HotelMapper;
import com.mcuneytozturk.saglikturizmi.mapper.RoomMapper;
import com.mcuneytozturk.saglikturizmi.model.HotelDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends BaseService<HotelEntity, HotelDTO, HotelMapper, HotelRepository> {
    private final HotelMapper hotelMapper;
    private final HotelRepository hotelRepository;

    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    public HotelService(HotelMapper hotelMapper,
                        HotelRepository hotelRepository,
                        RoomMapper roomMapper,
                        RoomRepository roomRepository) {
        this.hotelMapper = hotelMapper;
        this.hotelRepository = hotelRepository;
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    @Override
    protected HotelMapper getMapper() {
        return hotelMapper;
    }

    @Override
    protected HotelRepository getRepository() {
        return hotelRepository;
    }
}
