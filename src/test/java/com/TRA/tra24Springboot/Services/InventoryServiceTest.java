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

    /*
    This line tells Mockito to create a mock instance of the SchoolRepository class.
    This mock can then be used to simulate interactions with the repository
    in a controlled way during your tests.
    */
    @Mock
    private InventoryRepository inventoryRepository;


    /*
    This tells Mockito to create an instance of the SchoolService class
    and automatically inject the mock instance of SchoolRepository into it.
    This allows you to test SchoolService in isolation by using the mock SchoolRepository.
     */
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


        /*
        when: This is a Mockito method used to specify a behavior for a
                mock object when a particular method is called.

        schoolRepository.save(any(School.class)): This specifies that when the save method of
                                                  schoolRepository is called with any School object,
                                                  the behavior should be defined.

        thenReturn(school): This specifies that the save method should return the school object
                            when it is called with any School object.
        */

        /*
        This line effectively tells Mockito that when the save method is called on
        schoolRepository with any School object, it should return the predefined school object.
        */
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        InventoryDTO savedInventory = inventoryService.addInventory(inventory);


        /*
        verify: This is a Mockito method used to check if a particular method on a mock object was called.
        schoolRepository: This is the mock object on which the method call is verified.
        times(1): This specifies that the save method should be called exactly once.
        save(any(School.class)): This specifies that the save method should be called with any School object.
        */

        /*
        This line checks that the save method of
        schoolRepository was called exactly once with any School object.
        */
        verify(inventoryRepository, times(1)).save(any(Inventory.class));

        // Assert the returned school matches the mock data
        assertEquals("Sulaiman", savedInventory.getInventoryManager());
    }

    @Test
    void getInventoryByManager() {
    }

    @Test
    void deleteInventory() {
        String locationName = "Sinaw";

        Inventory mockInventory = Inventory.builder()
                .location(locationName)
                .build();
        mockInventory.setIsActive(true);

        when(inventoryRepository.getByLocationName(locationName));

        String result = inventoryService.deleteInventory(locationName);

        verify(inventoryRepository, times(1)).getByName(locationName);
        verify(inventoryRepository, times(1)).save(mockInventory);

        assertEquals("Success", result);

        assertEquals(false, mockInventory.getIsActive());

    }

    @Test
    void getAll() {
    }
}