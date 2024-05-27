package com.TRA.tra24Springboot.Services;

import com.TRA.tra24Springboot.DTO.OrderDTO;
import com.TRA.tra24Springboot.InvoiceRepositories.OrderRepository;
import com.TRA.tra24Springboot.Models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public OrderDTO createOrder(Order order){

        order.setIsActive(true);
        order.setCreatedDate(new Date());
        orderRepository.save(order);

        OrderDTO dto = OrderDTO.convertToDTO(order);
        return dto;
    }

    public String deleteOrderById(Integer id){
        for(Order order: orderRepository.findAll()){
            if(orderRepository.existsById(id)){
                orderRepository.deleteById(id);
                return "Order id " + id + " deleted successfuly";
            }
        }
        return "Did not delete";
    }

    public OrderDTO getOrderById(Integer id){
        Order order = orderRepository.getReferenceById(id);

        OrderDTO orderDTO = OrderDTO.convertToDTO(order);
        return orderDTO;
    }

    public List<OrderDTO> getAll(){
        List<Order> orders = orderRepository.findAll();
        return OrderDTO.convertToDTO(orders);
    }
}
