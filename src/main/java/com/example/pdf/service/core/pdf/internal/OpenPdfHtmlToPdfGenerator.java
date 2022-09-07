package com.example.pdf.service.core.pdf.internal;

import com.example.pdf.core.exception.PdfGenerationException;
import com.example.pdf.service.core.html.HtmlGenerator;
import com.example.pdf.service.core.pdf.HtmlToPdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.HtmlParser;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

@Component
public class OpenPdfHtmlToPdfGenerator implements HtmlToPdfGenerator {

    private final HtmlGenerator htmlGenerator;

    @Autowired
    public OpenPdfHtmlToPdfGenerator(final HtmlGenerator htmlGenerator) {
        this.htmlGenerator = htmlGenerator;
    }

    @Override
    public byte[] generate(final String templatePath, final Map<String, Object> context) {
        return generate(templatePath, context, PageSize.A4);
    }

    @Override
    public byte[] generate(final String templatePath, final Map<String, Object> context, final Rectangle pageSize) {
        return generate(templatePath, context, OpenPdfProperties.builder().pageSize(pageSize).build());
    }

    @Override
    public byte[] generate(final String templatePath, final Map<String, Object> context, final OpenPdfProperties pdfProperties) {
        try (final Document document = extractDocument(pdfProperties);
             final ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            final String html = htmlGenerator.generate(templatePath, context);
            HtmlParser.parse(document, new StringReader(html));
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new PdfGenerationException(e);
        }
    }

    /* Private methods */
    @NonNull
    private Document extractDocument(@NonNull final OpenPdfProperties pdfProperties) {
        final Document document = new Document();
        pdfProperties.getPageSize().ifPresent(document::setPageSize);
        pdfProperties.getMarginBottom().ifPresent(document::bottom);
        pdfProperties.getMarginRight().ifPresent(document::right);
        pdfProperties.getMarginLeft().ifPresent(document::left);
        pdfProperties.getMarginTop().ifPresent(document::top);
        return document;
    }

}
