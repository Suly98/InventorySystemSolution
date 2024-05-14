package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.InventoryService;
import jakarta.persistence.GeneratedValue;
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


    @PostMapping("delete")
    public String deleteInventory(@RequestParam String locationName){

        inventoryService.deleteInventory(locationName);
        return "Success!";
    }

    @GetMapping("getAll")
    public List<InventoryDTO> getInventories(){
        return inventoryService.getAll();
    }

}
