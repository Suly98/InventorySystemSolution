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
@RequestMapping("/Inventory")
public class InventoryController {

    Inventory newInventory = new Inventory();

    @Autowired
    InventoryRepository inventoryRepository;

    //InventoryService inventoryService;

    @PostMapping("add")
    public Inventory addStock(/*List<Product> productList*/) {

        newInventory.setLocation("Gala");
        newInventory.setManager("Ahmed");
        newInventory.setCreatedDate(new Date());
/*
        newInventory.setProducts(productList); will add it later
*/
        newInventory.setPhoneNumber("97796369");
        newInventory.setSupplier("Haider Darwish");
        newInventory.setReceivedDate(new Date());
        newInventory.setOpeningHours("from 10am - 12am");
        newInventory.setIsActive(Boolean.TRUE);

        return inventoryRepository.save(newInventory);
    }


    @PostMapping("return")
    public String returnProcess(@RequestParam Integer id, @RequestParam Integer quantity) {
        for (Product p : newInventory.getProducts()) {
            if (p.getId().equals(id)) {
                p.setQuantity(p.getQuantity() + quantity);
            } else {
                Product product = new Product();
                product.setId(id);
                product.setQuantity(quantity);
            }
        }
        return "Product returned Successfully!";
    }

}
