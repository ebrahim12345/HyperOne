package com.example.hyprerone.repository;

import com.example.hyprerone.dto.InvoiceDto;
import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>, JpaSpecificationExecutor<Invoice> {

    Optional<Invoice> findById(Long id);

    @Query("select i from Invoice i where i.invoiceNumber =:invoiceNumber")
    List<Invoice> findAllByInvoiceNumberOrderByDateAsc(@Param("invoiceNumber") Integer invoiceNumber);


    // query to get invoice total price of product
    @Query("SELECT SUM( i.totalPrice) FROM  Invoice i" +
            " INNER JOIN Product p ON p.id = i.productId.id WHERE i.invoiceNumber =:invoiceNumber")
    Integer findTotalPriceByInvoiceNumber(@Param("invoiceNumber") Integer invoiceNumber);


//    SELECT sum(invoice.total_proice * product.number_of_product)
//    FROM  hyper_one.invoice
//    INNER JOIN hyper_one.product ON product.id = product_id
//    WHERE invoice_number = 1000;

}
