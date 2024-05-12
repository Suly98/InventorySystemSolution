package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory){

        inventory.setCreatedDate(new Date());
        inventory.setIsActive(Boolean.TRUE);
        return inventoryRepository.save(inventory);
    }

    public String deleteInventory(String location){
        List<Inventory> inventoryToDel = inventoryRepository.getByLocationName(location);

        ArrayList<Inventory> updatedList = new ArrayList<>();

        for(Inventory inventory: inventoryToDel){
            inventory.setIsActive(false);
            updatedList.add(inventory);
        }
        inventoryRepository.saveAll(updatedList);
        return "Success";
    }


}
