package com.liverday.demo.application.infrastructure.product.persistence.inmemory;

import com.liverday.demo.application.domain.product.Product;
import com.liverday.demo.application.domain.product.ProductGateway;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductGateway implements ProductGateway {
  private final List<Product> products = new ArrayList<>();
  @Override
  public List<Product> findAll() {
    return products;
  }

  @Override
  public Optional<Product> findById(String id) {
    return products
        .stream()
        .filter(product -> product.getId().equals(id))
        .findFirst();
  }

  @Override
  public Product save(final Product product) {
    products.add(product);
    return product;
  }

  @Override
  public void deleteById(String id) {
    products.removeIf(product -> product.getId().equals(id));
  }
}
