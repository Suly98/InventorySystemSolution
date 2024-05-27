package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Inventory")
public class InventoryController {



    @Autowired
    InventoryService inventoryService;

    @PostMapping("addStock")
    public InventoryDTO addStock(@RequestBody Inventory inventory){
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


    @GetMapping("getByManager")
    public InventoryDTO getByManager(@RequestParam String managerName){
        return inventoryService.getInventoryByManager(managerName);
    }
}
