package com.example.hyprerone.dto;

import com.example.hyprerone.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
public class ProductDto {

    private Long id;
    private String productName;
    private Integer numberOfProduct;
    private Integer productPrice;
    private Integer totalPrice;



    // setting product properties
    public ProductDto fromModel(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setNumberOfProduct(product.getNumberOfProduct());
        dto.setProductPrice(product.getProductPrice());
        dto.setTotalPrice(product.getTotalPrice());
        return dto;
    }



}
