package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.InvoiceRepositories.OrderRepository;
import com.TRA.tra24Springboot.Models.*;
import com.TRA.tra24Springboot.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    Order order1 = new Order();

    @PostMapping("create")
    public OrderDTO createOrder(Order order){
        return orderService.createOrder(order);
    }

    @PutMapping("update")
    public Order updateOrder(@RequestBody Order userOrder){
        order1.setUpdatedDate(new Date());
        order1 = userOrder;
        return order1;
    }

    @PostMapping("cancel/{id}")
    public String cancelOrder(@PathVariable Integer id){
        if(order1.getId().equals(id)){
            order1.setStatus(OrderStatus.CANCELED);
        }

        return "Success";
    }

    @GetMapping("get")
    public Order reportOrder(){
        return order1;
    }
}
