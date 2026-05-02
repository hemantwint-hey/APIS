package org.example.ecommerce.service;

import org.example.ecommerce.payload.CartDTO;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements  CartService{
    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {
        return null;
    }
}
