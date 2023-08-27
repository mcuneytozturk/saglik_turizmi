package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.ReservationEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.ReservationRepository;
import com.mcuneytozturk.saglikturizmi.mapper.ReservationMapper;
import com.mcuneytozturk.saglikturizmi.model.ReservationDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService extends BaseService<ReservationEntity, ReservationDTO, ReservationMapper, ReservationRepository> {
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
    }
    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }
    @Override
    protected ReservationRepository getRepository() {
        return reservationRepository;
    }

    public void makePayment(UUID uuid){
        ReservationEntity entity = reservationRepository.findByUuid(uuid).orElse(null);
        if (entity != null){
            entity.setPaid(true);
            reservationRepository.save(entity);
        }
    }


    //Scheduled anotasyon'u ile her 10 dakikada bir bu metod çağrılarak ödenmemiş yani isPaid == false olan metodları bulacak onları bir listeye ekleyecek ve liste JpaRepository'e ait deleteAll metodu ile silinecektir.
    //aynı yorum satırı ve kod AppointmentServicetede kullanılmıştır
    @Scheduled(fixedRate = 600000) // 10 dakika (600000 milisaniye)
    public void checkUnpaidReservations() {
        List<ReservationEntity> unpaidAndExpiredReservations = reservationRepository.findAllByPaidIsFalseAndCreationDateBefore(LocalDateTime.now().minusMinutes(10));

        reservationRepository.deleteAll(unpaidAndExpiredReservations);

    }
}
