package com.example.hyprerone.serviceImpl;

import com.example.hyprerone.dto.InvoiceDto;
import com.example.hyprerone.exceptions.BadRequestException;
import com.example.hyprerone.exceptions.ObjectNotFoundException;
import com.example.hyprerone.exceptions.ResourceNotFoundException;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.repository.InvoiceRepository;
import com.example.hyprerone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override // find invoice by id
    public Invoice getOneInvoice(Long InvoiceId) throws Exception {
        return invoiceRepository.findById(InvoiceId)
                .orElseThrow(() -> new ObjectNotFoundException("موردی یافت نشد ! "));
    }


    @Override // find invoice by invoice number
    public List<Invoice> getInvoice(Integer invoiceNumber) throws Exception {
        List<Invoice> invoice = invoiceRepository.findAllByInvoiceNumberOrderByDateAsc(invoiceNumber);
        if (invoice.size() == 0) {
            throw new ObjectNotFoundException("کالایی برای فاکتور وارد شده ثبت نشده است  !");
        }
        return invoice;
    }




    @Override
    public ResponseEntity<Object> createInvoice(@RequestBody List<Invoice> productList, @PathVariable Integer invoiceNumber) throws Exception {

        Date currentDate = new Date();
        if (invoiceNumber == null) {
            throw new BadRequestException("شماره فاکتور برای ثبت کالا وارد نمایید !");
        }
        for (Invoice invoice : productList) {
            if (invoice.getProductId() == null) {
                throw new BadRequestException("شناسه کالا را وارد نمایید !");
            }
            invoice.setProductId(invoice.getProductId());
            invoice.setInvoiceNumber(invoiceNumber);
            invoice.setDate(currentDate);
            invoiceRepository.save(invoice);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
