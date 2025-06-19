package com.piassa.sales_analytics_api.controller;

import com.piassa.sales_analytics_api.model.dto.ProductDTO;
import com.piassa.sales_analytics_api.model.entity.Product;
import com.piassa.sales_analytics_api.repository.IProductRepository;
import com.piassa.sales_analytics_api.services.MetricsService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductRepository productRepository;
    private final MetricsService metricsService;

    public ProductController(IProductRepository productRepository, MetricsService metricsService) {
        this.productRepository = productRepository;
        this.metricsService = metricsService;
    }

    @Operation(summary = "Criar um novo produto", description = "Inserir um novo produto no sistema com nome, categoria e preço unitário.")
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO dto) {
        Product product = new Product(null, dto.name(), dto.category(), dto.unitPrice());
        Product saved = productRepository.save(product);

        metricsService.incrementProductCreated();

        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Buscar todos os produtos", description = "Buscar toddos os produtos sem filtro.")
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
}
