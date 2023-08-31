package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.PatientRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserRoleEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PatientRoleRepository extends BaseRepository<PatientRoleEntity> {
    Optional<PatientRoleEntity> findByName(String name);
}
