package com.piassa.sales_analytics_api.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record SalesDTO(

        @NotNull(message = "O ID do produto é obrigatório.")
        Long productId,

        @NotNull(message = "A quantidade é obrigatória.")
        @Positive(message = "A quantidade deve ser maior que zero.")
        Integer quantity,

        @NotNull(message = "A data da venda é obrigatória.")
        LocalDate salesDate

) {}
