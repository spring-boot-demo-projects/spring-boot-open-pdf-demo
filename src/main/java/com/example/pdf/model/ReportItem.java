package com.example.pdf.model;

import org.springframework.lang.NonNull;

public record ReportItem(
        Long id,
        String title,
        String description
) {

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private String title;
        private String description;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        @NonNull
        public ReportItem build() {
            return new ReportItem(id, title, description);
        }

    }

}
