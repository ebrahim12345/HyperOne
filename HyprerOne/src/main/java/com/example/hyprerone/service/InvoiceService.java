package com.example.hyprerone.service;


import com.example.hyprerone.dto.InvoiceDto;
import com.example.hyprerone.model.Invoice;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface InvoiceService {
    ResponseEntity<Object> createInvoice(List<Invoice> productDtos, Integer invoiceNumber) throws Exception;

    Invoice getOneInvoice(Long InvoiceId) throws Exception;

    List <InvoiceDto> getInvoice(Integer InvoiceId) throws Exception;

    Integer getInvoiceTotalPrice(Integer voiceNumber) throws Exception;

}
