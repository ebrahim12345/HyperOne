package com.example.hyprerone.model;

import com.example.hyprerone.dto.ProductDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "Product")
@Accessors(chain = true)
public class Product {



    @Id // this field's value will be generated by hibernate sequence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "product_name")
    private String productName;

    @Column(name = "number_of_product")
    private Integer numberOfProduct;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "total_proice")
    private Integer totalPrice;




    // setting product dto
    public Product fromDto(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setProductName(dto.getProductName());
        product.setNumberOfProduct(dto.getNumberOfProduct());
        product.setProductPrice(dto.getProductPrice());
        product.setTotalPrice(dto.getTotalPrice());
        return product;
    }

}
