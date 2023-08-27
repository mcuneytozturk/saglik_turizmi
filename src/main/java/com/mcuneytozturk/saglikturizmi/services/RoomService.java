package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.RoomRepository;
import com.mcuneytozturk.saglikturizmi.mapper.PatientMapper;
import com.mcuneytozturk.saglikturizmi.mapper.RoomMapper;
import com.mcuneytozturk.saglikturizmi.model.PatientDTO;
import com.mcuneytozturk.saglikturizmi.model.RoomDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    private final PatientMapper patientMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper, PatientMapper patientMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.patientMapper = patientMapper;
    }

    public RoomEntity createReservation(RoomDTO roomDTO, PatientDTO patientDTO){
        RoomEntity room = roomMapper.dtoToEntity(roomDTO);
        PatientEntity patient = patientMapper.dtoToEntity(patientDTO);

        roomRepository.save(room);

        return room;
    }
}
