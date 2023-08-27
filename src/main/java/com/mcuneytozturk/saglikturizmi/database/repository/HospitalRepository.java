package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.HospitalEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends BaseRepository<HospitalEntity> {
}
