package com.TRA.tra24Springboot.DTO;

import com.TRA.tra24Springboot.Models.Order;
import com.TRA.tra24Springboot.Models.OrderStatus;
import com.TRA.tra24Springboot.Models.PaymentType;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    String categoryNameDTO;
    Date orderedDateDTO;
    List<ProductDTO> productsOrderedDTO;
    OrderStatus status;
    String descriptionDTO;
    PaymentType paymentType;


    public static OrderDTO convertToDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setCategoryNameDTO(order.getCategoryName());
        orderDTO.setOrderedDateDTO(order.getOrderDate());
        orderDTO.setProductsOrderedDTO(order.getProductsOrdered());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDescriptionDTO(order.getDescription());
        orderDTO.setPaymentType(order.getPaymentType());

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
