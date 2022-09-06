package com.example.pdf.service.core.pdf.internal;

import com.example.pdf.service.core.exception.PdfGenerationException;
import com.example.pdf.service.core.html.HtmlGenerator;
import com.example.pdf.service.core.pdf.HtmlToPdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.html.HtmlParser;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

@Component
public class HtmlToPdfGeneratorImpl implements HtmlToPdfGenerator {

    private final HtmlGenerator htmlGenerator;

    @Autowired
    public HtmlToPdfGeneratorImpl(final HtmlGenerator htmlGenerator) {
        this.htmlGenerator = htmlGenerator;
    }

    @Override
    public byte[] generate(final String templatePath, final Map<String, Object> context) {
        try (final Document document = new Document();
             final ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            HtmlParser.parse(document, new StringReader(htmlGenerator.generate(templatePath, context)));
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new PdfGenerationException(e);
        }
    }

}
