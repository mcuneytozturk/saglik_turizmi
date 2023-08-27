package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.HotelEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.HotelRepository;
import com.mcuneytozturk.saglikturizmi.mapper.HotelMapper;
import com.mcuneytozturk.saglikturizmi.model.HotelDTO;
import com.mcuneytozturk.saglikturizmi.services.HotelService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
public class HotelController extends BaseController<HotelEntity, HotelDTO, HotelRepository, HotelMapper, HotelService> {
    private final HotelService hotelService;
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @Override
    protected HotelService getService() {
        return hotelService;
    }
}
