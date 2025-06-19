package com.piassa.sales_analytics_api.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDTO(

        @NotBlank(message = "O nome do produto é obrigatório.")
        @Size(max = 100, message = "O nome do produto deve ter no máximo 100 caracteres.")
        String name,

        @NotBlank(message = "A categoria é obrigatória.")
        @Size(max = 50, message = "A categoria deve ter no máximo 50 caracteres.")
        String category,

        @NotNull(message = "O preço unitário é obrigatório.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O preço unitário deve ser maior que zero.")
        @Digits(integer = 10, fraction = 2, message = "O preço unitário deve ter no máximo 10 dígitos inteiros e 2 decimais.")
        BigDecimal unitPrice

) {}
