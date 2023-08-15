package com.example.hyprerone.serviceImpl;

import com.example.hyprerone.dto.ProductDto;
import com.example.hyprerone.exceptions.BadRequestException;
import com.example.hyprerone.exceptions.ObjectNotFoundException;
import com.example.hyprerone.exceptions.ResourceNotFoundException;
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
    public Product createProduct(ProductDto dto) throws Exception {
        Product product = new Product().fromDto(dto);

        if (dto.getProductName() == null) {
            throw new BadRequestException("نام کالا را وارد کنید !");
        }
        if (dto.getProductPrice() == null) {
            throw new BadRequestException("مبلغ  کالا را وارد کنید !");
        }
        if (dto.getNumberOfProduct() == null) {
            throw new BadRequestException("تعداد  کالا را وارد کنید !");
        }
        product.setTotalPrice(dto.getProductPrice());
        productRepository.save(product);
        return product;
    }


    @Override // find a product by id
    public Product getOneProduct(Long productId) throws Exception {
       return productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("موردی یافت نشد ! "));
    }

}
