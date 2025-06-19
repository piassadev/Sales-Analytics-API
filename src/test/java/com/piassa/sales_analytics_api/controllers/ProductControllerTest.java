package com.piassa.sales_analytics_api.controllers;

import com.piassa.sales_analytics_api.controller.ProductController;
import com.piassa.sales_analytics_api.model.dto.ProductDTO;
import com.piassa.sales_analytics_api.model.entity.Product;
import com.piassa.sales_analytics_api.repository.IProductRepository;
import com.piassa.sales_analytics_api.services.MetricsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductControllerUnitTest {


    @Mock
    private IProductRepository productRepository;

    @Mock
    private MetricsService metricsService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProduct() {
        ProductDTO dto = new ProductDTO("Produto B", "Categoria B", BigDecimal.valueOf(20));
        Product savedProduct = new Product(1L, dto.name(), dto.category(), dto.unitPrice());

        when(productRepository.save(any())).thenReturn(savedProduct);

        var response = productController.createProduct(dto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Produto B", response.getBody().getName());
        assertEquals(BigDecimal.valueOf(20), response.getBody().getUnitPrice());
    }
}
