package com.example.hyprerone.serviceImpl;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.model.Product;
import com.example.hyprerone.repository.ProductRepository;
import com.example.hyprerone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {



    @Autowired
    private ProductRepository productRepository;



    @Override
    public Product createProduct(Product product) throws Exception {
        ProductDto dto = new ProductDto().fromModel(product);
        if (dto.getProductName() == null ){
            throw new Exception("نام کالا را وارد کنید !");
        }
        if (dto.getProductPrice() == null ){
            throw new Exception("مبلغ  کالا را وارد کنید !");
        }
        if (dto.getNumberOfProduct() == null ){
            throw new Exception("تعداد  کالا را وارد کنید !");
        }
        productRepository.save(product);
        return product;
    }


    @Override // find a product by id
    public Product getOneProduct(Long productId) throws Exception {
        return productRepository.findById(productId)
                .orElseThrow(() -> new Exception("موردی یافت نشد ! "));
    }

}
