package com.example.hyprerone.repository;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>, JpaSpecificationExecutor<Invoice> {

    Optional<Invoice> findById(Long id);

    void save(ProductDto products);
}
