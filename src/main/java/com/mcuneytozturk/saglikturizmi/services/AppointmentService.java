package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.ReservationEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AppointmentRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AppointmentMapper;
import com.mcuneytozturk.saglikturizmi.model.AppointmentDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService extends BaseService<AppointmentEntity, AppointmentDTO, AppointmentMapper, AppointmentRepository> {
    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentMapper appointmentMapper, AppointmentRepository appointmentRepository) {
        this.appointmentMapper = appointmentMapper;
        this.appointmentRepository = appointmentRepository;
    }
    @Override
    protected AppointmentMapper getMapper() {
        return appointmentMapper;
    }
    @Override
    protected AppointmentRepository getRepository() {
        return appointmentRepository;
    }
    //Scheduled anotasyon'u ile her 10 dakikada bir bu metod çağrılarak ödenmemiş yani isPaid == false olan metodları bulacak onları bir listeye ekleyecek ve liste JpaRepository'e ait deleteAll metodu ile silinecektir.
    //aynı yorum satırı ve kod ReservationService'tede kullanılmıştır
    @Scheduled(fixedRate = 600000) // 10 dakika (600000 milisaniye)
    public void checkUnacceptedAppointments() {
        List<AppointmentEntity> unpaidAndExpiredReservations = appointmentRepository.findAllByAcceptedIsFalseAndCreationDateBefore(LocalDateTime.now().minusMinutes(10));

        appointmentRepository.deleteAll(unpaidAndExpiredReservations);

    }
}
