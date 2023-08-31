package com.mcuneytozturk.saglikturizmi.database.repository;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.UserRoleEntity;
import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseRepository;

import java.util.Optional;

public interface AdminRoleRepository extends BaseRepository<AdminRoleEntity> {
    Optional<AdminRoleEntity> findByName(String name);
}
