package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Inventory extends BaseEntity {

    @OneToMany
    List<Product> productsInInventory;

    @OneToMany
    List<Order> ordersInInventory;

    String location;
    String manager; //TODO: Update once user class created
    List<String> workers; //TODO: Update user class created
    String supplier; //TODO: Update once supplier class created
    String phoneNumber;
    String openingHours;
    String closingHours;



}
