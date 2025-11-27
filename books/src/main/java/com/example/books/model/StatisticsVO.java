package com.example.books.model;

public class StatisticsVO {

    private String month;

    private long totalResponses;

    private long acceptedResponses;

    public StatisticsVO() {
    }

    public StatisticsVO(String month, long totalResponses, long acceptedResponses) {
        this.month = month;
        this.totalResponses = totalResponses;
        this.acceptedResponses = acceptedResponses;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public long getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(long totalResponses) {
        this.totalResponses = totalResponses;
    }

    public long getAcceptedResponses() {
        return acceptedResponses;
    }

    public void setAcceptedResponses(long acceptedResponses) {
        this.acceptedResponses = acceptedResponses;
    }
}
