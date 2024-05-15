package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.ProductRepository;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Models.ProductDetails;
import com.TRA.tra24Springboot.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;



    @PostMapping("add")
    public ProductDTO addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @PostMapping("delete")
    public String deleteById(@RequestParam Integer id){
        return productService.deleteProductById(id);
    }

//    @PostMapping("delete/{id}")
//    public String deleteProduct(@PathVariable Integer id){
//
//            if(globalProduct.getId().equals(id)){
//                globalProduct.setIsActive(Boolean.FALSE);
//                System.out.println(globalProduct.toString());
//
//        }
//        return "Success!";
//    }

//    @PutMapping("update")
//    public Product updateProduct(@RequestBody Product userProduct){
//
//
//        ProductDetails pd = userProduct.getProductDetails();
//        pd.setUpdatedDate(new Date());
//
//        userProduct.setProductDetails(pd);
//        userProduct.setUpdatedDate(new Date());
//
//        globalProduct = userProduct;
//        return globalProduct;
//    }

    @GetMapping("get")
    public ProductDTO getProductById(@RequestParam Integer id){
        return productService.getProductById(id);
    }
    @GetMapping("getAll")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
