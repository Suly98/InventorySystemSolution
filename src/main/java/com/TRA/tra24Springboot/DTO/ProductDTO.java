package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {

    Integer id;
    Integer quantity;
    String category;
    ProductDetails productDetails;

    public static ProductDTO convertToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductDetails(product.getProductDetails());
        productDTO.setCategory(product.getCategory());
        productDTO.setQuantity(product.getQuantity());

        return productDTO;
    }

    public static List<ProductDTO> convertToDTO(List<Product> productList){
        List<ProductDTO> productDTOs = new ArrayList<>();

        for(Product productFromDB: productList){
            ProductDTO dto = convertToDTO(productFromDB);
            productDTOs.add(dto);
        }
        return productDTOs;
    }
}
