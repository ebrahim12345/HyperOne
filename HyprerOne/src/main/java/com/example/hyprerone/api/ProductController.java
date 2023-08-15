package com.example.hyprerone.api;


import com.example.hyprerone.dto.ProductDto;
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


    // define a product
    @PostMapping(value = "defineProduct", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity createProduct(
            @RequestBody ProductDto productDto) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.productService.createProduct(productDto));
    }





    //  get one product
    @RequestMapping(value = "findProductById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Product> findPersonById(@PathVariable Long id) throws Exception {
            return new ResponseEntity<>(productService.getOneProduct(id), HttpStatus.OK);

    }
}
