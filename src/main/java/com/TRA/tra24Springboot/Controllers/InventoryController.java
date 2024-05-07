package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class InventoryController {

    Inventory newInventory = new Inventory();

      //this will add a list of products and orders to the inventory
//    that is already there
    public Inventory addStock(List<Product> productList){
        newInventory.setLocation("Ghala");
        newInventory.setManager("Ahmed");
        newInventory.setProducts(productList);
        newInventory.setPhoneNumber("97796369");
        newInventory.setSupplier("Haider Darwish");
        newInventory.setReceivedDate(new Date());
        newInventory.setOpeningHours("from 10am - 12am");

        return newInventory;
    }





}
