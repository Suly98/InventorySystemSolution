package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.InvoiceRepositories.OrderRepository;
import com.TRA.tra24Springboot.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    public OrderDTO createOrder(@RequestBody Order order){
        order.setProductsOrdered(productService.getAllProducts());


    }


}
