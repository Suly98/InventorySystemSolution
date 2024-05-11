package com.TRA.tra24Springboot.InvoiceRepositories;

import com.TRA.tra24Springboot.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory, Integer> {

}
