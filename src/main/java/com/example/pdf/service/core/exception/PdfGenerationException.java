package com.example.pdf.service.core.exception;

@SuppressWarnings("unused")
public class PdfGenerationException extends RuntimeException {

    public static final String PDF_GENERATION_DEFAULT_EXCEPTION_MESSAGE = "During PDF generation an exception occurred";

    public PdfGenerationException() {
        super(PDF_GENERATION_DEFAULT_EXCEPTION_MESSAGE);
    }

    public PdfGenerationException(String message) {
        super(message);
    }

    public PdfGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PdfGenerationException(Throwable cause) {
        super(PDF_GENERATION_DEFAULT_EXCEPTION_MESSAGE, cause);
    }

    protected PdfGenerationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
