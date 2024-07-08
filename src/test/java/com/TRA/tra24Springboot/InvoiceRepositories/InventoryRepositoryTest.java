package com.TRA.tra24Springboot.InvoiceRepositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.assertj.core.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

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
                .supplier("Ahmed")
                .build();

        Inventory inventory2 = Inventory.builder().location("Sinaw City")
                .manager("Nasser")
                .supplier("abu hamood")
                .build();

        inventoryRepository.save(inventory2);
        inventoryRepository.save(inventory1);
    }

    @Test
    public void getByLocationName() {
        List<Inventory> inventory = inventoryRepository.getByLocationName("Sinaw City");
        Assertions.assertThat(inventory).isNotNull();
        Assertions.assertThat(inventory.getFirst().getLocation()).isEqualTo("Sinaw City");
    }

    @Test
    public void getByName() {
        Inventory inventory = inventoryRepository.getByName("Mohammed");
        Assertions.assertThat(inventory).isNotNull();
        Assertions.assertThat(inventory.getSupplier()).isEqualTo("Ahmed");
    }


}