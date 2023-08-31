package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.AdminRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientEntity;
import com.mcuneytozturk.saglikturizmi.database.entity.PatientRoleEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AdminRepository;
import com.mcuneytozturk.saglikturizmi.database.repository.AdminRoleRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AdminMapper;
import com.mcuneytozturk.saglikturizmi.model.AdminDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService extends BaseService<AdminEntity, AdminDTO, AdminMapper, AdminRepository> {
    private final AdminMapper adminMapper;
    private final AdminRepository adminRepository;

    @Autowired
    AdminRoleRepository adminRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AdminService(AdminMapper adminMapper, AdminRepository adminRepository) {
        this.adminMapper = adminMapper;
        this.adminRepository = adminRepository;
    }

    @Override
    protected AdminMapper getMapper() {
        return adminMapper;
    }

    @Override
    protected AdminRepository getRepository() {
        return adminRepository;
    }

    public void saveAdminByRole(AdminEntity admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Set<AdminRoleEntity> roles = new HashSet<>();
        roles.add(adminRoleRepository.findByName("user").get());
        admin.setRoles(roles);
        adminRepository.save(admin);
    }
}
