package com.example.hyprerone.dto;

import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Accessors(chain = true)
public class InvoiceDto {


    private Long id;
    private Long invoiceNumber;
    private Date date;
    private Product productId;



    // setting product properties
    public InvoiceDto fromModel(Invoice invoice) {
        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setInvoiceNumber(invoice.getInvoiceNumber());
        dto.setDate(invoice.getDate());
        dto.setProductId(invoice.getProductId());
         Product productId;
        return dto;
    }

}
