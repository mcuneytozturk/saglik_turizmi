package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.UserEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity> {
    Optional<UserEntity> findByEmail(String email);
}
