package com.liverday.demo.application.infrastructure.product.persistence.jpa;

import com.liverday.demo.application.domain.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaProductEntity {

  @Id
  private String id;

  @Column(name = "category", nullable = false)
  private String category;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "name", nullable = false)
  private String name;

  public static JpaProductEntity from(final Product product) {
    return new JpaProductEntity(
        product.getId(),
        product.getCategory(),
        product.getPrice(),
        product.getName()
    );
  }

  public Product toEntity() {
    return Product.with(
        this.id,
        this.category,
        this.price,
        this.name
    );
  }
}
