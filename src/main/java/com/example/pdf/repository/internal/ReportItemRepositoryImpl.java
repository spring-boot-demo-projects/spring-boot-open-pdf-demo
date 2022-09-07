package com.example.pdf.repository.internal;

import com.example.pdf.model.ReportItem;
import com.example.pdf.repository.ReportItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class ReportItemRepositoryImpl implements ReportItemRepository {

    @Override
    public List<ReportItem> findAllReportItems(final int amount) {
        return Stream.iterate(0L, i -> ++i).limit(amount)
                .map(i -> ReportItem.builder().id(i).title("Title " + i).description("Description " + i).build())
                .toList();
    }

}
