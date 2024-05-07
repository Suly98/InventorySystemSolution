package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ReportingController {

    @GetMapping("warning")
    public void lowOnInventory(List<Product> productList) {
        if (productList.size() <= 5) {
            System.out.println("INVENTORY IS LOW!!");
        } else {
            System.out.println("Inventory is OK!");
        }
    }

    public Boolean isThere(Inventory products){
        for(Product p : products.getProducts() ){
            if(p.getQuantity().equals(0)){
                return false;
            }
        }
        return true;
    }

}
