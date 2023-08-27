package com.mcuneytozturk.saglikturizmi.services;

import com.mcuneytozturk.saglikturizmi.database.entity.ReportEntity;
import com.mcuneytozturk.saglikturizmi.database.repository.ReportRepository;
import com.mcuneytozturk.saglikturizmi.mapper.ReportMapper;
import com.mcuneytozturk.saglikturizmi.model.ReportDTO;
import com.mcuneytozturk.saglikturizmi.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends BaseService<ReportEntity, ReportDTO, ReportMapper, ReportRepository> {
    private final ReportMapper reportMapper;
    private final ReportRepository reportRepository;

    public ReportService(ReportMapper reportMapper, ReportRepository reportRepository) {
        this.reportMapper = reportMapper;
        this.reportRepository = reportRepository;
    }

    @Override
    protected ReportMapper getMapper() {
        return reportMapper;
    }

    @Override
    protected ReportRepository getRepository() {
        return reportRepository;
    }
}
