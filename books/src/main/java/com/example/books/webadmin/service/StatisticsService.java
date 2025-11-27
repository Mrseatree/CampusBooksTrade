package com.example.books.webadmin.service;

import com.example.books.model.StatisticsVO;
import com.example.books.webadmin.repository.BookDealRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    private final BookDealRepository bookDealRepository;

    public StatisticsService(BookDealRepository bookDealRepository) {
        this.bookDealRepository = bookDealRepository;
    }

    public List<StatisticsVO> getRecentStatistics() {
        LocalDate end = LocalDate.now().withDayOfMonth(1).plusMonths(1).minusDays(1);
        LocalDate start = end.minusMonths(5).withDayOfMonth(1);
        List<StatisticsVO> response = new ArrayList<>();

        for (int i = 5; i >= 0; i--) {
            LocalDate monthStart = start.plusMonths(i);
            LocalDate monthEnd = monthStart.withDayOfMonth(monthStart.lengthOfMonth());
            long total = bookDealRepository.findDealsBetween(monthStart, monthEnd).size();
            long accepted = bookDealRepository.findDealsBetween(monthStart, monthEnd)
                    .stream()
                    .filter(BookDealRepository.BookDeal::accepted)
                    .count();
            response.add(new StatisticsVO(FORMATTER.format(monthStart), total, accepted));
        }
        return response;
    }
}
