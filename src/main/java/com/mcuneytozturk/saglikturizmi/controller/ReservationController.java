package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.ReservationEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.ReservationRepository;
import com.mcuneytozturk.saglikturizmi.mapper.ReservationMapper;
import com.mcuneytozturk.saglikturizmi.model.ReservationDTO;
import com.mcuneytozturk.saglikturizmi.services.ReservationService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController extends BaseController<ReservationEntity, ReservationDTO, ReservationRepository, ReservationMapper, ReservationService> {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @Override
    protected ReservationService getService() {
        return reservationService;
    }
}
