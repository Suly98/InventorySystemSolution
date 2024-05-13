package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.InvoiceRepositories.ProductRepository;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;



    public Product addProduct(Product product, ProductDetails productDetails){
        product.setSku(UUID.randomUUID());
        product.setIsActive(true);
        product.setCreatedDate(new Date());

        product.setProductDetails(Arrays.asList(productDetails));
        return productRepository.save(product);

    }

}
