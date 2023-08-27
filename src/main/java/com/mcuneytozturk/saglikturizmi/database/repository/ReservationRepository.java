package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.ReservationEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservationRepository extends BaseRepository<ReservationEntity> {
    List<ReservationEntity> findAllByPaidIsFalseAndCreationDateBefore(LocalDateTime date);


}
