package com.example.pdf.web;

import com.example.pdf.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
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
    public ResponseEntity<byte[]> generateReport() {
        return ResponseEntity.ok()
                .header(CONTENT_DISPOSITION, "attachment; filename=report.pdf")
                .body(reportService.generateReport());
    }

}
