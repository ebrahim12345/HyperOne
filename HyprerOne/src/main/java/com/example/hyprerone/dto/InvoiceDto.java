package com.example.hyprerone.dto;

import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Accessors(chain = true)
public class InvoiceDto {



    private Long id;
    private Integer invoiceNumber;
    private Date date;
    private ProductDto productId;
    private Integer totalPrice;
    private Integer numberOfProduct;


    // setting invoice properties
    public InvoiceDto fromModel(Invoice invoice) {
        InvoiceDto dto = new InvoiceDto();
//        dto.setId(invoice.getId());
        dto.setInvoiceNumber(invoice.getInvoiceNumber());
        dto.setDate(invoice.getDate());
        dto.setProductId(dto.getProductId());
        dto.setTotalPrice(invoice.getTotalPrice());
        return dto;
    }

}
