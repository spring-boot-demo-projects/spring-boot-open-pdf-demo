package com.example.pdf.service.core.pdf.internal;

import com.lowagie.text.Rectangle;
import org.springframework.lang.NonNull;

import java.util.Optional;

@SuppressWarnings("unused")
public record OpenPdfProperties(
        Float marginTop,
        Float marginLeft,
        Float marginRight,
        Float marginBottom,
        Rectangle pageSize
) {

    public Optional<Float> getMarginTop() {
        return Optional.ofNullable(marginTop());
    }

    public Optional<Float> getMarginLeft() {
        return Optional.ofNullable(marginLeft());
    }

    public Optional<Float> getMarginRight() {
        return Optional.ofNullable(marginRight());
    }

    public Optional<Float> getMarginBottom() {
        return Optional.ofNullable(marginBottom());
    }

    public Optional<Rectangle> getPageSize() {
        return Optional.ofNullable(pageSize());
    }

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Float marginTop;
        private Float marginLeft;
        private Float marginRight;
        private Float marginBottom;
        private Rectangle pageSize;

        public Builder marginTop(Float marginTop) {
            this.marginTop = marginTop;
            return this;
        }

        public Builder marginLeft(Float marginLeft) {
            this.marginLeft = marginLeft;
            return this;
        }

        public Builder marginRight(Float marginRight) {
            this.marginRight = marginRight;
            return this;
        }

        public Builder marginBottom(Float marginBottom) {
            this.marginBottom = marginBottom;
            return this;
        }

        public Builder pageSize(Rectangle pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        @NonNull
        public OpenPdfProperties build() {
            return new OpenPdfProperties(marginTop, marginLeft, marginRight, marginBottom, pageSize);
        }

    }

}
