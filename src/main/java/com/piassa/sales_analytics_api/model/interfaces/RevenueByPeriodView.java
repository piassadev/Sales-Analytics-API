package com.piassa.sales_analytics_api.model.interfaces;

import java.math.BigDecimal;

public interface RevenueByPeriodView {
    String getPeriod();
    BigDecimal getRevenue();
}