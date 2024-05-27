package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class OrderDTO {
    Integer id;
    String categoryName;
    Date orderedDateDTO;
    String description;



    public static OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setCategoryName(order.getCategoryName());
        orderDTO.setOrderedDateDTO(new Date());
        orderDTO.setDescription(order.getDescription());
        return orderDTO;
    }

    public static List<OrderDTO> convertToDTO(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for(Order order: orders){
            OrderDTO dto = convertToDTO(order);
            orderDTOS.add(dto);

        }
        return orderDTOS;
    }
}
