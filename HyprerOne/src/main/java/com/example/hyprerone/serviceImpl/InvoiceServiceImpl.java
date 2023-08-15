package com.example.hyprerone.serviceImpl;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.repository.InvoiceRepository;
import com.example.hyprerone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;




    @Override
    public Invoice createInvoice(List<ProductDto> products) throws Exception {
        Invoice invoice = new Invoice();
        Date currentDate = new Date();
        for (ProductDto product : products) {
            if (product.getId() != null)
                invoice.setDate(currentDate);
            invoiceRepository.save(product);
        }
        return null;
    }


    @Override // find invoice by id
    public Invoice getOneInvoice(Long InvoiceId) throws Exception {
        return invoiceRepository.findById(InvoiceId)
                .orElseThrow(() -> new Exception("موردی یافت نشد ! "));
    }
}
