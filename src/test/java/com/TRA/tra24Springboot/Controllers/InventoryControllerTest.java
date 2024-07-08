package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.InvoiceRepositories.InventoryRepository;
import com.TRA.tra24Springboot.Services.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

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