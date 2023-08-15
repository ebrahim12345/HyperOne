package com.example.hyprerone.api;


import com.example.hyprerone.model.Product;
import com.example.hyprerone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/product")
@Controller
public class ProductController {


    @Autowired
    private ProductService productService;


    // create a product
    @PostMapping(value = "createProduct", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity createProduct(
            @RequestBody Product product) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.productService.createProduct(product));
    }





    //  get one product
    @RequestMapping(value = "findProductById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findPersonById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(productService.getOneProduct(id), HttpStatus.OK);
    }

}
