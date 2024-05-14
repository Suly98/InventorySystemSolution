package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.ProductDetails;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProductDetailsDTO {
    String name;
    String countryOfOrigin;
    Date expiryDate;
    String size;
    String color;
    String description;
    Double price;


    public static ProductDetailsDTO convertToDTO(ProductDetails productDetails){
        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();

        productDetailsDTO.setName(productDetails.getName());
        productDetailsDTO.setColor(productDetails.getColor());
        productDetailsDTO.setSize(productDetails.getSize());
        productDetailsDTO.setDescription(productDetails.getDescription());
        productDetailsDTO.setPrice(productDetails.getPrice());
        productDetailsDTO.setCountryOfOrigin(productDetails.getCountryOfOrigin());
        productDetailsDTO.setExpiryDate(productDetails.getExpiryDate());

        return productDetailsDTO;
    }

    public static List<ProductDetailsDTO> convertToDTO(List<ProductDetails> productDetailsList){
        List<ProductDetailsDTO> productDetailsDTOs = new ArrayList<>();

        for(ProductDetails productDetailsFromDB: productDetailsList){
            ProductDetailsDTO dto = convertToDTO(productDetailsFromDB);
            productDetailsDTOs.add(dto);
        }

        return productDetailsDTOs;
    }
}
