package com.example.books.webadmin.controller;

import com.example.books.model.StatisticsVO;
import com.example.books.webadmin.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/recent")
    public List<StatisticsVO> getRecentStatistics() {
        return statisticsService.getRecentStatistics();
    }
}
