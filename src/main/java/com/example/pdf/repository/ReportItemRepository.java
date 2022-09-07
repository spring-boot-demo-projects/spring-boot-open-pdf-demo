package com.example.pdf.repository;

import com.example.pdf.model.ReportItem;

import java.util.List;

public interface ReportItemRepository {

    List<ReportItem> findAllReportItems(int amount);

}
