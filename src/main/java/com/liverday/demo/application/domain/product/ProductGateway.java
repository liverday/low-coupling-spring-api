package com.liverday.demo.application.domain.product;


import java.util.List;
import java.util.Optional;

// Abstração do repositório pra ser implementado independente da plataforma.
public interface ProductGateway {
  List<Product> findAll();
  Optional<Product> findById(final String id);
  Product save(final Product product);
  void deleteById(final String id);
}
