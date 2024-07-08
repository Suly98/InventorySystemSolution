package com.TRA.tra24Springboot.InvoiceRepositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class InventoryRepositoryTest {

    @Autowired
    private InventoryRepository inventoryRepository;

    @BeforeEach
    void setUp(){
        Inventory inventory1 = Inventory.builder().location("Russel City")
                .manager("Mohammed")
                .build();

        Inventory inventory2 = Inventory.builder().location("Sinaw City")
                .manager("Nasser")
                .supplier("abu hamood")
                .build();
    }

    @Test
    void getByLocationName() {
    }

    @Test
    void getByName() {
    }
}