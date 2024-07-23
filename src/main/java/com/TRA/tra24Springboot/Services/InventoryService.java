package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
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

    public InventoryDTO addInventory(Inventory inventory){

        inventory.setCreatedDate(new Date());
        inventory.setIsActive(Boolean.TRUE);
        inventoryRepository.save(inventory);

        InventoryDTO inventoryDTO = InventoryDTO.convertToDTO(inventory);

        return inventoryDTO;
    }

    public InventoryDTO getInventoryByManager(String managerName){
        Inventory inventory = inventoryRepository.getByName(managerName);

        InventoryDTO inventoryDTO = InventoryDTO.convertToDTO(inventory);
        return inventoryDTO;
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

    public String deleteByManager(String manager){
        Inventory inventoryToDelete = inventoryRepository.getByName(manager);
        inventoryToDelete.setIsActive(false);
        return "Success";
    }

    public List<InventoryDTO> getAll(){
        List<Inventory> inventories = inventoryRepository.findAll();

        return InventoryDTO.convertToDTO(inventories);

    }


}
