package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.OrderDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.OrderRepository;
import com.TRA.tra24Springboot.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    public OrderDTO createOrder(@RequestBody Order order){
        order.setIsActive(true);
        order.setCreatedDate(new Date());
        orderRepository.save(order);

        OrderDTO dto = OrderDTO.convertToDTO(order);
        return dto;
    }


}
