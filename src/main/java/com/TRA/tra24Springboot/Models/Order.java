package com.TRA.tra24Springboot.Models;

import com.TRA.tra24Springboot.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @OneToMany
    List<ProductDTO> productsOrdered;
    String categoryName;
    Date orderDate;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    String description;

    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    PaymentType paymentType;
    Date updatedDate;
    Date dueDate;
}
