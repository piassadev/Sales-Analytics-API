package com.piassa.sales_analytics_api.repository;

import com.piassa.sales_analytics_api.model.entity.Sales;
import com.piassa.sales_analytics_api.model.dto.DailyRevenueDTO;
import com.piassa.sales_analytics_api.model.interfaces.RevenueByPeriodView;
import com.piassa.sales_analytics_api.model.dto.TopProductDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ISalesRepository extends JpaRepository<Sales, Long> {

    @Query("SELECT new com.piassa.sales_analytics_api.model.dto.TopProductDTO(s.product.name, SUM(s.quantity)) " +
            "FROM Sales s GROUP BY s.product.name " +
            "ORDER BY SUM(s.quantity) DESC")
    List<TopProductDTO> findTopSellingProduct(Pageable pageable);

    @Query("""
    SELECT
        FUNCTION('to_char', s.salesDate, 'YYYY-MM') as period,
        SUM(s.quantity * s.product.unitPrice) as revenue
    FROM Sales s
    GROUP BY FUNCTION('to_char', s.salesDate, 'YYYY-MM')
    ORDER BY FUNCTION('to_char', s.salesDate, 'YYYY-MM')
    """)
    List<RevenueByPeriodView> findMonthlyRevenue();

    @Query("SELECT new com.piassa.sales_analytics_api.model.dto.DailyRevenueDTO(s.salesDate, SUM(s.quantity * s.product.unitPrice)) " +
            "FROM Sales s GROUP BY s.salesDate ORDER BY s.salesDate")
    List<DailyRevenueDTO> findDailyRevenueTrend();

}
