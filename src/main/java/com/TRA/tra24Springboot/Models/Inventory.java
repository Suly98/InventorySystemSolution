package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
public class Inventory extends BaseEntity {

    @OneToMany
    List<Product> productsInInventory;

    @OneToMany
    List<Order> ordersInInventory;

    String location;
    String manager;
    List<String> workers;
    String supplier;
    String phoneNumber;
    String openingHours;
    String closingHours;



}
