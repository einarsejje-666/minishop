package com.tecsup.minishop.dto;

import com.tecsup.minishop.model.Product;

/**
 * Datos que el cliente puede enviar al crear un producto.
 * Evita exponer la entidad JPA en el controlador (regla java:S4684).
 */
public record ProductRequest(String name, Double price, Integer stock) {

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .build();
    }
}
