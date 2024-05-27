package com.TRA.tra24Springboot.InvoiceRepositories;

import com.TRA.tra24Springboot.DTO.InventoryDTO;
import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository <Inventory, Integer>{

    //to initiate a new function to delete by location name
    @Query("SELECT inv FROM Inventory inv WHERE inv.location =:loc")
    List<Inventory> getByLocationName(@Param("loc") String location);

    @Query("SELECT m FROM Inventory m WHERE m.manager =:manager")
    Inventory getByName(@Param("manager") String managerName);

}
