package com.example.hyprerone.api;


import com.example.hyprerone.dto.InvoiceDto;
import com.example.hyprerone.model.Invoice;
import com.example.hyprerone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/product")
@Controller
public class InvoiceController {


    @Autowired
    private InvoiceService invoiceService;


    //  create invoice through defining product in it
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



    //  get one invoice by id
    @RequestMapping(value = "findInvoiceById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Invoice> findInvoiceById(@PathVariable Long id) throws Exception {
            return new ResponseEntity<>(invoiceService.getOneInvoice(id), HttpStatus.OK);
    }



    //  get one invoice by invoice number

    @RequestMapping(value = "findInvoiceByInvoiceNumber/{invoiceNumber}", method = RequestMethod.GET)
    @ResponseBody
    public List <InvoiceDto> findInvoiceByInvoiceNumber(@PathVariable Integer invoiceNumber) throws Exception {
            return invoiceService.getInvoice(invoiceNumber);
    }



    //  get invoice total price by invoice number
    @RequestMapping(value = "findInvoiceTotalPrice/{invoiceNumber}", method = RequestMethod.GET)
    @ResponseBody
    public Integer findInvoiceTotalPrice(@PathVariable Integer invoiceNumber) throws Exception {
        return invoiceService.getInvoiceTotalPrice(invoiceNumber);
    }
}
