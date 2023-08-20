package com.example.hyprerone.repository;


import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Optional<Product> findById(Long id);

    @Query(value ="select  p from Product p where p.id =:productId")
    Product findProductById(@Param("productId") Long productId);

}
