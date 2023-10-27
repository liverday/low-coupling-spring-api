package com.liverday.demo.application.application.usecases.product.create;

public record CreateProductInput(
    String category,
    Double price,
    String name
) {}