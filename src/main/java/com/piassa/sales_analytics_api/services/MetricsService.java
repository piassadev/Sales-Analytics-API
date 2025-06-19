package com.piassa.sales_analytics_api.services;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class MetricsService {

    private final Counter productCreatedCounter;

    public MetricsService(MeterRegistry registry) {
        this.productCreatedCounter = Counter.builder("custom.metrics.product.created")
                .description("Contador de produtos criados")
                .register(registry);
    }

    public void incrementProductCreated() {
        productCreatedCounter.increment();
    }
}
