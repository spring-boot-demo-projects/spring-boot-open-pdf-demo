package com.example.pdf.service.core.html.internal;

import com.example.pdf.service.core.html.HtmlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

@Component
public class ThymeleafHtmlGenerator implements HtmlGenerator {

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final TemplateEngine templateEngine;
    private final ServletContext servletContext;

    @Autowired
    public ThymeleafHtmlGenerator(final HttpServletRequest request,
                                  final HttpServletResponse response,
                                  final TemplateEngine templateEngine,
                                  final ServletContext servletContext) {
        this.request = request;
        this.response = response;
        this.templateEngine = templateEngine;
        this.servletContext = servletContext;
    }

    @Override
    public String generate(final String templatePath, final Map<String, Object> context) {
        final Locale locale = LocaleContextHolder.getLocale();
        return templateEngine.process(templatePath, new WebContext(request, response, servletContext, locale, context));
    }

}
