package com.liverday.demo.application.domain.product;


import com.liverday.demo.application.domain.Entity;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Entity {
  private final String id;
  private final String category;
  private final Double price;
  private final String name;

  // Aqui só vão métodos disponíveis na JDK, sem nenhum tipo de dependência externa.
  private Product(
      final String id,
      final String category,
      final Double price,
      final String name) {
    super();
    this.id = id;
    this.category = category;
    this.price = price;
    this.name = name;
  }

  public static Product newProduct(
      final String category,
      final Double price,
      final String name
  ) {
    return new Product(
        UUID.randomUUID().toString(),
        category,
        price,
        name
    );
  }

  public static Product with(
      final String id,
      final String category,
      final Double price,
      final String name
  ) {
    return new Product(
        id,
        category,
        price,
        name
    );
  }
}
