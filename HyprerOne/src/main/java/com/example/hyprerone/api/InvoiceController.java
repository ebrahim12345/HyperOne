package com.example.hyprerone.api;


import com.example.hyprerone.dto.InvoiceDto;
import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.model.Product;
import com.example.hyprerone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/product")
@Controller
public class InvoiceController {


    @Autowired
    private InvoiceService invoiceService;


    //  get one invoice
    @PostMapping(value = "createInvoice/{invoiceNumber}")
    public ResponseEntity<Object> createInvoiceOfProduct(@RequestBody List<Invoice> productList, @PathVariable Integer invoiceNumber) {
        if ((!productList.isEmpty()) && invoiceNumber != null) {
            try {
                return new ResponseEntity<>(invoiceService.createInvoice(productList, invoiceNumber), HttpStatus.CREATED);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return ResponseEntity.badRequest().body("خطا در عملیات، لطفا فیلد های ورودی را بررسی نمایید !");

    }



    //  get one invoice
    @RequestMapping(value = "findInvoiceById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Invoice> findPersonById(@PathVariable Long id) throws Exception {
            return new ResponseEntity<>(invoiceService.getOneInvoice(id), HttpStatus.OK);
    }



    //  get one invoice

    @RequestMapping(value = "findInvoiceInvoiceNumber/{invoiceNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List <InvoiceDto> findPersonById(@PathVariable Integer invoiceNumber) throws Exception {
            return invoiceService.getInvoice(invoiceNumber);
    }
}
