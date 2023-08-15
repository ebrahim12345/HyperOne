package com.example.hyprerone.service;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.model.Product;

import java.util.List;

public interface InvoiceService {
    public Invoice createInvoice(List<ProductDto> productDtos) throws Exception;

    Invoice getOneInvoice(Long InvoiceId) throws Exception;

}
