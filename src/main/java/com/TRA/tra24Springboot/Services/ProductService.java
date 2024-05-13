package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.InvoiceRepositories.ProductDetailsRepository;
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


    @Autowired
    ProductDetailsServices productDetailsServices;


    public Product addProduct(Product product){
        product.setSku(UUID.randomUUID());
        product.setIsActive(true);
        product.setCreatedDate(new Date());

        productDetailsServices.addToProduct(product.getProductDetails());

        return productRepository.save(product);

    }
}
