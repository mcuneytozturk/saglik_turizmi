package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class AdminRoleEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String description;
    @ManyToMany(mappedBy = "roles")
    private Set<AdminEntity> admins;

    public AdminRoleEntity() {

    }
}
