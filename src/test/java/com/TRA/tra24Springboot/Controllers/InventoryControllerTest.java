package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Services.InventoryService;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryControllerTest {


    @Mock
    private InventoryRepository inventoryRepository;



    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void addStock() {
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

//    @Test
//    void deleteInventory() {
//    }
//
//    @Test
//    void getInventories() {
//    }
//
//    @Test
//    void getByManager() {
//    }
}