package com.liverday.demo.application.application.usecases.product.list;

import com.liverday.demo.application.domain.product.ProductGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultListProductsUseCase implements ListProductsUseCase {
  private final ProductGateway productGateway;

  @Override
  public ListProductsOutput execute() {
    return ListProductsOutput.from(productGateway.findAll());
  }
}
