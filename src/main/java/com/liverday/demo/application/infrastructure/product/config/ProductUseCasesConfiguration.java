package com.liverday.demo.application.infrastructure.product.config;

import com.liverday.demo.application.application.usecases.product.create.CreateProductUseCase;
import com.liverday.demo.application.application.usecases.product.create.DefaultCreateProductUseCase;
import com.liverday.demo.application.application.usecases.product.list.DefaultListProductsUseCase;
import com.liverday.demo.application.application.usecases.product.list.ListProductsUseCase;
import com.liverday.demo.application.domain.product.ProductGateway;
import com.liverday.demo.application.infrastructure.product.persistence.jpa.JpaProductGateway;
import com.liverday.demo.application.infrastructure.product.persistence.jpa.JpaProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("unused")
public class ProductUseCasesConfiguration {
  @Bean
  public ProductGateway productGateway(final JpaProductRepository jpaProductRepository) {
    // Pra conseguir alterar o storage, basta trocar a implementação de ProductGateway;
    // Para alterar para uma versão inmemory, instancie uma classe InMemoryProductGateway;
    // return new InMemoryProductGateway();

    return new JpaProductGateway(jpaProductRepository);
  }

  @Bean
  public CreateProductUseCase createProductUseCase(
      final ProductGateway productGateway
  ) {
    return new DefaultCreateProductUseCase(productGateway);
  }

  @Bean
  public ListProductsUseCase listProductsUseCase(
      final ProductGateway productGateway
  ) {
    return new DefaultListProductsUseCase(productGateway);
  }
}
