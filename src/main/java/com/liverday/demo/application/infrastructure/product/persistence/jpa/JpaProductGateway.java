package com.liverday.demo.application.infrastructure.product.persistence.jpa;

import com.liverday.demo.application.domain.product.Product;
import com.liverday.demo.application.domain.product.ProductGateway;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaProductGateway implements ProductGateway {
  private final JpaProductRepository productRepository;

  @Override
  public List<Product> findAll() {
    return productRepository.findAll()
        .stream()
        .map(JpaProductEntity::toEntity)
        .toList();
  }

  @Override
  public Optional<Product> findById(final String id) {
    return productRepository.findById(id)
        .map(JpaProductEntity::toEntity);
  }

  @Override
  public Product save(final Product product) {
    return productRepository.save(JpaProductEntity.from(product))
        .toEntity();
  }

  @Override
  public void deleteById(final String id) {
    productRepository.deleteById(id);
  }
}
