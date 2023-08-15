package com.example.hyprerone.service;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Product;

public interface ProductService <I,O>{


    Product createProduct(Product product) throws Exception;

    Product getOneProduct(Long productId) throws Exception;


}
