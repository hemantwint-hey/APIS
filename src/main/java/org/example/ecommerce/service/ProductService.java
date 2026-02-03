package org.example.ecommerce.service;

import org.example.ecommerce.model.Product;
import org.example.ecommerce.payload.ProductDTO;
import org.example.ecommerce.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();
}

