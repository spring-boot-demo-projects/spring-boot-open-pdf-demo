package com.example.pdf.service.core.html.internal;

import com.example.pdf.service.core.html.HtmlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;

@Component
public class ThymeleafHtmlGenerator implements HtmlGenerator {

    private final TemplateEngine templateEngine;

    @Autowired
    public ThymeleafHtmlGenerator(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String generate(final String templatePath, Map<String, Object> context) {
        final Locale locale = LocaleContextHolder.getLocale();
        return templateEngine.process(templatePath, new Context(locale, context));
    }

}
