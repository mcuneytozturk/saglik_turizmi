package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.RoomEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends BaseRepository<RoomEntity> {
}
