package com.mcuneytozturk.saglikturizmi.controller;

import com.mcuneytozturk.saglikturizmi.database.entity.ReportEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.ReportRepository;
import com.mcuneytozturk.saglikturizmi.mapper.ReportMapper;
import com.mcuneytozturk.saglikturizmi.model.ReportDTO;
import com.mcuneytozturk.saglikturizmi.services.ReportService;
import com.mcuneytozturk.saglikturizmi.util.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("report")
public class ReportController extends BaseController<ReportEntity, ReportDTO, ReportRepository, ReportMapper, ReportService> {
    private final ReportService reportService;
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @Override
    protected ReportService getService() {
        return reportService;
    }
}
