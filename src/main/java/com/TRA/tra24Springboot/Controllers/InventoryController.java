package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Services.InventoryService;
import com.TRA.tra24Springboot.Services.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Autowired
    SlackService slackService;

    //notify the customer everytime he add stock!
    @Scheduled(cron = "30 5 * * * ?")
    @PostMapping("addStock")
    public InventoryDTO addStock(@RequestBody Inventory inventory){
        String channel = "Teams";
        String message = "a Stock has been added!";
        slackService.sendMessage(channel, message);
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
