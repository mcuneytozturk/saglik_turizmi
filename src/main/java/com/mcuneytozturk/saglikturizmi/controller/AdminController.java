package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.AdminEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.AdminRepository;
import com.mcuneytozturk.saglikturizmi.mapper.AdminMapper;
import com.mcuneytozturk.saglikturizmi.model.AdminDTO;
import com.mcuneytozturk.saglikturizmi.services.AdminService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Admin")
public class AdminController extends BaseController<AdminEntity, AdminDTO, AdminRepository, AdminMapper, AdminService> {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    protected AdminService getService() {
        return adminService;
    }
}
