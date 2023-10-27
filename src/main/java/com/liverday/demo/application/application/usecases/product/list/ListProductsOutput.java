package com.liverday.demo.application.application.usecases.product.list;

import com.liverday.demo.application.domain.product.Product;
import java.util.List;

public record ListProductsOutput (
    List<Product> products
) {
  public static ListProductsOutput from(final List<Product> products) {
    return new ListProductsOutput(products);
  }
}
