package com.martin.microserivices.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

// Paso 2

@Document(value = "product")
@Data
@AllArgsConstructor // crea un constructor con todos los atributos
@NoArgsConstructor // crea un constructor sin atributos
@Builder // crea un constructor con el patron builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
