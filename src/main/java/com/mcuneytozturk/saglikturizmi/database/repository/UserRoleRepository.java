package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.UserRoleEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;

import java.util.Optional;

public interface UserRoleRepository extends BaseRepository<UserRoleEntity> {
    Optional<UserRoleEntity> findByName(String name);
}
