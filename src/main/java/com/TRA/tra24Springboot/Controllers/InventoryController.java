package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("Inventory")
public class InventoryController {



    @Autowired
    InventoryService inventoryService;

    @PostMapping("addStock")
    public Inventory addStock(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }


/*    @PostMapping("return")
    public String returnProcess(@RequestParam Integer id, @RequestParam Integer quantity) {
        for (Product p : newInventory.getProductsInInventory()) {
            if (p.getId().equals(id)) {
                p.setQuantity(p.getQuantity() + quantity);
            } else {
                Product product = new Product();
                product.setId(id);
                product.setQuantity(quantity);
            }
        }
        return "Product returned Successfully!";
    }*/

}
