package com.piassa.sales_analytics_api.repository.dataInitializer;

import com.piassa.sales_analytics_api.model.entity.Product;
import com.piassa.sales_analytics_api.model.entity.Sales;
import com.piassa.sales_analytics_api.repository.IProductRepository;
import com.piassa.sales_analytics_api.repository.ISalesRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

    private final IProductRepository productRepository;
    private final ISalesRepository salesRepository;

    public DataInitializer(IProductRepository productRepository, ISalesRepository salesRepository) {
        this.productRepository = productRepository;
        this.salesRepository = salesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (productRepository.count() == 0 && salesRepository.count() == 0) {

            Product p1 = productRepository.save(new Product(null, "Camiseta Básica", "Roupas", new BigDecimal("39.90")));
            Product p2 = productRepository.save(new Product(null, "Calça Jeans", "Roupas", new BigDecimal("89.90")));
            Product p3 = productRepository.save(new Product(null, "Tênis Esportivo", "Calçados", new BigDecimal("199.90")));
            Product p4 = productRepository.save(new Product(null, "Boné Estiloso", "Acessórios", new BigDecimal("29.90")));
            Product p5 = productRepository.save(new Product(null, "Meia Esportiva", "Acessórios", new BigDecimal("9.90")));

            // Inserir vendas
            salesRepository.saveAll(List.of(
                    new Sales(null, 10, LocalDate.of(2025, 5, 1), p4),
                    new Sales(null, 10, LocalDate.of(2025, 5, 5), p1),
                    new Sales(null, 3, LocalDate.of(2025, 5, 1), p1),
                    new Sales(null, 10, LocalDate.of(2025, 6, 1), p1),
                    new Sales(null, 5,  LocalDate.of(2025, 6, 2), p2),
                    new Sales(null, 3,  LocalDate.of(2025, 6, 3), p3),
                    new Sales(null, 7,  LocalDate.of(2025, 6, 4), p1),
                    new Sales(null, 15, LocalDate.of(2025, 6, 4), p4),
                    new Sales(null, 20, LocalDate.of(2025, 6, 5), p5),
                    new Sales(null, 12, LocalDate.of(2025, 6, 6), p1),
                    new Sales(null, 2,  LocalDate.of(2025, 6, 6), p3),
                    new Sales(null, 4,  LocalDate.of(2025, 6, 7), p2),
                    new Sales(null, 30, LocalDate.of(2025, 6, 8), p5),
                    new Sales(null, 8,  LocalDate.of(2025, 6, 9), p4),
                    new Sales(null, 9,  LocalDate.of(2025, 6,10), p1),
                    new Sales(null, 6,  LocalDate.of(2025, 6,10), p2),
                    new Sales(null, 4,  LocalDate.of(2025, 6,11), p3)
            ));
        }
    }
}