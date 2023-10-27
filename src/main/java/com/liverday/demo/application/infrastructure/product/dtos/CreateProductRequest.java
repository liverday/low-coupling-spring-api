package com.liverday.demo.application.infrastructure.product.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateProductRequest (
    @JsonProperty("category") String category,
    @JsonProperty("price") Double price,
    @JsonProperty("name") String name
) {}
