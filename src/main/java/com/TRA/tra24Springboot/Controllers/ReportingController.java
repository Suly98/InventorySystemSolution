package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ReportingController {

    Inventory inventory1 = new Inventory();

    @GetMapping("inventoryCheck")
    public void lowOnInventory(@NotNull List<Product> productList) {
        if (productList.size() <= 5) {
            System.out.println("INVENTORY IS LOW!!");
        } else {
            System.out.println("Inventory is OK!");
        }
    }

    @GetMapping("isThere")
    public Boolean isThere(@NotNull Inventory products){
        for(Product p : products.getProductsInInventory() ){
            if(p.getQuantity().equals(0)){
                return false;
            }
        }
        return true;
    }

    @GetMapping("report")
    public Inventory reportAll(){
        return inventory1;
    }


}
