package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.ProductDetailsDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.ProductDetailsRepository;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductDetailsServices {

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public ProductDetailsDTO addToProduct(ProductDetails productDetails){
        productDetails.setCreatedDate(new Date());
        productDetails.setIsActive(true);

        productDetailsRepository.save(productDetails);

        ProductDetailsDTO dto = ProductDetailsDTO.convertToDTO(productDetails);

        return dto;
    }
}
