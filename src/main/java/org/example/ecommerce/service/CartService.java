package org.example.ecommerce.service;

import org.example.ecommerce.payload.CartDTO;
import org.springframework.stereotype.Service;


public interface CartService {
     CartDTO addProductToCart(Long productId, Integer quantity);
}
