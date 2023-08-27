package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.AppointmentEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends BaseRepository<AppointmentEntity> {
    List<AppointmentEntity> findAllByAcceptedIsFalseAndCreationDateBefore(LocalDateTime date);
}
