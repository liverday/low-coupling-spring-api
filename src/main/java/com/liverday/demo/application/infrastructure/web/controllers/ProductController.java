package com.liverday.demo.application.infrastructure.web.controllers;

import com.liverday.demo.application.application.usecases.product.create.CreateProductInput;
import com.liverday.demo.application.application.usecases.product.create.CreateProductUseCase;
import com.liverday.demo.application.application.usecases.product.list.ListProductsUseCase;
import com.liverday.demo.application.domain.product.Product;
import com.liverday.demo.application.infrastructure.product.dtos.CreateProductRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class ProductController {
  private final CreateProductUseCase createProduct;
  private final ListProductsUseCase listProducts;

  @GetMapping
  public List<Product> list() {
    return listProducts
        .execute()
        .products();
  }

  @PostMapping
  public String create(
      @RequestBody CreateProductRequest request
  ) {
    return createProduct
        .execute(new CreateProductInput(
            request.category(),
            request.price(),
            request.name()
        ))
        .id();
  }
}
