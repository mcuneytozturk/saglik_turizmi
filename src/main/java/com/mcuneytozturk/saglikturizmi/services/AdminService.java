package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AdminRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AdminMapper;
import com.mcuneytozturk.saglikturizmi.model.AdminDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends BaseService<AdminEntity, AdminDTO, AdminMapper, AdminRepository> {
    private final AdminMapper adminMapper;
    private final AdminRepository adminRepository;

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
}
