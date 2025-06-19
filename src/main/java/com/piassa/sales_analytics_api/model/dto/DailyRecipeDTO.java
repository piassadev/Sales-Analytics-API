package com.piassa.sales_analytics_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DailyRecipeDTO(LocalDate salesDate, BigDecimal revenue) {
}