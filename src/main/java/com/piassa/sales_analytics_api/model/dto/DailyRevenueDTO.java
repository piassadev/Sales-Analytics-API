package com.piassa.sales_analytics_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DailyRevenueDTO(LocalDate date, BigDecimal revenue) {
    public DailyRevenueDTO(LocalDate date, Number rawSum) {
        this(date, new BigDecimal(rawSum.toString()));
    }
}