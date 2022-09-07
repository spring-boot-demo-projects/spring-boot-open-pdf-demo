package com.example.pdf.service.core.pdf;

import com.example.pdf.service.core.pdf.internal.OpenPdfProperties;
import com.lowagie.text.Rectangle;

import java.util.Map;

public interface HtmlToPdfGenerator {

    byte[] generate(String templatePath, Map<String, Object> context);

    byte[] generate(String templatePath, Map<String, Object> context, Rectangle pageSize);

    byte[] generate(String templatePath, Map<String, Object> context, OpenPdfProperties pdfProperties);

}
