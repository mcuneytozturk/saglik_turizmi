package com.mcuneytozturk.saglikturizmi.database.entity;

import com.mcuneytozturk.saglikturizmi.util.dbUtil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "admins")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "admin_uuid"
        )
)
@Data
public class AdminEntity extends BaseEntity {
        @Column
        private String adminName;
        @Column
        private String firstName;
        @Column
        private String lastName;
        @Column
        private String password;
}
