package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Models.Inventory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InventoryServiceTest {


    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void addInventory() {
        String location = "Sur";
        String manager = "Sulaiman";
        // prepare Mock Date:
        Inventory inventory = Inventory.builder()
                .manager(manager)
                .location(location)
                .phoneNumber("9779")
                .build();

        inventory.setIsActive(true);
        inventory.setLocation("Sur");

        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        InventoryDTO savedInventory = inventoryService.addInventory(inventory);

        verify(inventoryRepository, times(1)).save(any(Inventory.class));

        assertEquals("Sulaiman", savedInventory.getInventoryManager());
    }

    @Test
    void getInventoryByManager() {
    }

    @Test
    void deleteInventory() {
    }

    @Test
    void getAll() {
    }
}