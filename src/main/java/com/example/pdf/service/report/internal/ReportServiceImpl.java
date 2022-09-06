package com.example.pdf.service.report.internal;

import com.example.pdf.core.pdf.HtmlToPdfGenerator;
import com.example.pdf.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    private final HtmlToPdfGenerator pdfGenerator;

    @Autowired
    public ReportServiceImpl(final HtmlToPdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public byte[] generateReport() {
        return this.pdfGenerator.generate("demo-report", Map.of());
    }

}
