package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.ProductDetailsRepository;
import com.TRA.tra24Springboot.InvoiceRepositories.ProductRepository;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    @Autowired
    ProductDetailsServices productDetailsServices;


    public ProductDTO addProduct(Product product){
        product.setSku(UUID.randomUUID());
        product.setIsActive(true);
        product.setCreatedDate(new Date());

        productDetailsServices.addProductDetails(product.getProductDetails());

        productRepository.save(product);

        ProductDTO dto = ProductDTO.convertToDTO(product);

        return dto;
    }

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return ProductDTO.convertToDTO(products);
    }
}
