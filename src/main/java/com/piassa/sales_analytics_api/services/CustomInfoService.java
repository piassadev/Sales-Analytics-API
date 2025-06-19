package com.piassa.sales_analytics_api.services;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomInfoService implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of(
                "name", "Sales Analytics API",
                "description", "API para análise de vendas",
                "version", "1.0.3",
                "authors", "Gabriel Piassa"
        ));
    }
}
