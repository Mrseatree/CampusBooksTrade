package com.example.books.webadmin.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDealRepository {

    private final List<BookDeal> deals = new ArrayList<>();

    public BookDealRepository() {
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            deals.add(new BookDeal(now.minusMonths(i).withDayOfMonth(1), true));
            deals.add(new BookDeal(now.minusMonths(i).withDayOfMonth(15), i % 2 == 0));
        }
    }

    public List<BookDeal> findDealsBetween(LocalDate startInclusive, LocalDate endInclusive) {
        return deals.stream()
                .filter(deal -> !deal.date().isBefore(startInclusive) && !deal.date().isAfter(endInclusive))
                .collect(Collectors.toList());
    }

    public record BookDeal(LocalDate date, boolean accepted) {
    }
}
