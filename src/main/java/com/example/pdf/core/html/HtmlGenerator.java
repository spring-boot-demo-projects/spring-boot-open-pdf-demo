package com.example.pdf.core.html;

import java.util.Map;

public interface HtmlGenerator {

    String generate(String templatePath, Map<String, Object> context);

}
