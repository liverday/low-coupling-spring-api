package com.liverday.demo.application.application.usecases.product.create;

import com.liverday.demo.application.domain.product.Product;
import com.liverday.demo.application.domain.product.ProductGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCreateProductUseCase implements CreateProductUseCase {
  private final ProductGateway productGateway;

  @Override
  public CreateProductOutput execute(final CreateProductInput input) {
    final Product newProduct = Product.newProduct(
        input.category(),
        input.price(),
        input.name()
    );

    final Product savedProduct = productGateway.save(newProduct);
    return CreateProductOutput.from(savedProduct);
  }
}
