package com.example.pdf.service.report.internal;

import com.example.pdf.model.ReportItem;
import com.example.pdf.repository.ReportItemRepository;
import com.example.pdf.service.core.pdf.HtmlToPdfGenerator;
import com.example.pdf.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    private final HtmlToPdfGenerator pdfGenerator;
    private final ReportItemRepository reportItemRepository;

    @Autowired
    public ReportServiceImpl(final HtmlToPdfGenerator pdfGenerator,
                             final ReportItemRepository reportItemRepository) {
        this.pdfGenerator = pdfGenerator;
        this.reportItemRepository = reportItemRepository;
    }

    @Override
    public byte[] generateReport() {
        final List<ReportItem> reportItems = reportItemRepository.findAllReportItems(10);
        return this.pdfGenerator.generate("demo-report", Map.of("reportItems", reportItems));
    }

}
