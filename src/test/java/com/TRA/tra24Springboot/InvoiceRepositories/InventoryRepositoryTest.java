package com.TRA.tra24Springboot.InvoiceRepositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

@ActiveProfiles("test")


class InventoryRepositoryTest {

    @Autowired


    @Test
    void getByLocationName() {
    }

    @Test
    void getByName() {
    }
}