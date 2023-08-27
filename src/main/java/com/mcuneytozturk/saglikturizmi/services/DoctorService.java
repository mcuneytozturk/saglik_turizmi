package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.DoctorEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AppointmentRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.DoctorRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AppointmentMapper;
import com.mcuneytozturk.saglikturizmi.mapper.DoctorMapper;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.model.DoctorDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoctorService extends BaseService<DoctorEntity, DoctorDTO, DoctorMapper, DoctorRepository> {
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository, AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    protected DoctorMapper getMapper() {
        return doctorMapper;
    }
    @Override
    protected DoctorRepository getRepository() {
        return doctorRepository;
    }

    public AppointmentDTO createAppointmentToDoctorUuid( UUID uuid, AppointmentDTO appointmentDTO){
        AppointmentEntity appointment = appointmentMapper.dtoToEntity(appointmentDTO);
        Optional<DoctorEntity> doctorEntity = doctorRepository.findByUuid(uuid);
        if (doctorEntity.isPresent()){
            if (doctorEntity.get().getAppointments() != null){
                doctorEntity.get().getAppointments().add(appointment);
            } else {
                List<AppointmentEntity> appointments = new ArrayList<>();
                doctorEntity.get().setAppointments(appointments);
            }
            appointmentRepository.save(appointment);
            doctorRepository.save(doctorEntity.get());
        }

        return appointmentMapper.entityToDTO(appointment);
    }

    public AppointmentDTO updateAppointmentByIdAndDoctorUUID(UUID doctorUuid, Long appointmentId, AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = appointmentRepository.findById(appointmentId).orElse(null);
        DoctorEntity doctorEntity = doctorRepository.findByUuid(doctorUuid).orElse(null);
        if (doctorEntity != null && appointmentEntity != null){
            appointmentEntity = appointmentMapper.dtoToExistEntity(appointmentEntity, appointmentDTO);
            doctorEntity.getAppointments().add(appointmentEntity);
            appointmentRepository.save(appointmentEntity);
            doctorRepository.save(doctorEntity);
            return appointmentMapper.entityToDTO(appointmentEntity);

        } else {
            return null;
        }
    }

    public Boolean deleteAppointmentByUUID(UUID uuid){
        AppointmentEntity appointment = appointmentRepository.findByUuid(uuid).orElse(null);
        if (appointment != null){
            appointmentRepository.delete(appointment);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
