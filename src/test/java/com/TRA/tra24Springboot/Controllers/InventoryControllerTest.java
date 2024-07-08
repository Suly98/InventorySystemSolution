package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class InventoryControllerTest {

    @Mock
    private InventoryRepository inventoryRepository;



    @InjectMocks
    private InventoryController inventoryController;


    @Test
    void addStock() {
    }

    @Test
    void deleteInventory() {
    }

    @Test
    void getInventories() {
    }

    @Test
    void getByManager() {
    }
}