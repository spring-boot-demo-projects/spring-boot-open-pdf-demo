package com.example.pdf.core.pdf;

import java.util.Map;

public interface HtmlToPdfGenerator {

    byte[] generate(String templatePath, Map<String, Object> context);

}
