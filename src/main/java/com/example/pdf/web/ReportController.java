package com.example.pdf.web;

import com.example.pdf.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

@RestController
@RequestMapping(path = "/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(final ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/generate.pdf", produces = APPLICATION_PDF_VALUE)
    public byte[] generateReport() {
        return reportService.generateReport();
    }

}
