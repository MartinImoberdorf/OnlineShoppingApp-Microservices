package com.martin.microserivices.productservice.service;

import com.martin.microserivices.productservice.dto.ProductRequest;
import com.martin.microserivices.productservice.dto.ProductResponse;
import com.martin.microserivices.productservice.model.Product;
import com.martin.microserivices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// Paso 5

@Slf4j // para el log
@Service
@RequiredArgsConstructor // agrega un constructor con los atributos finales
public class ProductService {
    private final ProductRepository productRepository;

    // Método para crear un producto
    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    // Método para obtener todos los productos
    public List<ProductResponse> getAllProducts() {
        log.info("Getting all products");
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                )).toList();
    }
}
