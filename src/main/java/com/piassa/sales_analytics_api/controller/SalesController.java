package com.piassa.sales_analytics_api.controller;

import com.piassa.sales_analytics_api.model.dto.DailyRevenueDTO;
import com.piassa.sales_analytics_api.model.dto.SalesDTO;
import com.piassa.sales_analytics_api.model.entity.Product;
import com.piassa.sales_analytics_api.model.entity.Sales;
import com.piassa.sales_analytics_api.model.interfaces.RevenueByPeriodView;
import com.piassa.sales_analytics_api.model.dto.TopProductDTO;
import com.piassa.sales_analytics_api.repository.IProductRepository;
import com.piassa.sales_analytics_api.repository.ISalesRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final ISalesRepository salesRepository;
    private final IProductRepository productRepository;

    public SalesController(ISalesRepository salesRepository, IProductRepository productRepository) {
        this.salesRepository = salesRepository;
        this.productRepository = productRepository;
    }

    @Operation(summary = "Registrar uma nova venda", description = "Inserir um novo registro de venda.")
    @PostMapping
    public ResponseEntity<?> registerSale(@RequestBody @Valid SalesDTO dto) {

        var productOpt = productRepository.findById(dto.productId());

        if (productOpt.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Produto com ID " + dto.productId() + " não encontrado.");
        }

        Sales sale = new Sales(null, dto.quantity(), dto.salesDate(), productOpt.get());

        Sales saved = salesRepository.save(sale);

        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Buscar produtos e quantidade vendida", description = "Buscar produtos vendidos.")
    @GetMapping("/top-product")
    public List<TopProductDTO> getTopSellingProduct(Pageable pageable) {
        return salesRepository.findTopSellingProduct(pageable);
    }

    @Operation(summary = "Buscar receita por mes", description = "Buscar todas as receitas de cada mes.")
    @GetMapping("/revenue-by-month")
    public List<RevenueByPeriodView> getMonthlyRevenue() {
        return salesRepository.findMonthlyRevenue();
    }

    @Operation(summary = "Buscar receita por dia", description = "Buscar todas as receitas de cada dia.")
    @GetMapping("/daily-trend")
    public List<DailyRevenueDTO> getDailyTrend() {
        return salesRepository.findDailyRevenueTrend();
    }
}
