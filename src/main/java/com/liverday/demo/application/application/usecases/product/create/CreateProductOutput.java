package com.liverday.demo.application.application.usecases.product.create;

import com.liverday.demo.application.domain.product.Product;

public record CreateProductOutput(
    String id
) {
  public static CreateProductOutput from(final Product product) {
    return new CreateProductOutput(product.getId());
  }
}
