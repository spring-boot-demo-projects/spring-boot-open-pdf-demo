package com.example.pdf.service.core.html;

import java.util.Map;

public interface HtmlGenerator {

    String generate(String templatePath, Map<String, Object> context);

}
