package com.TRA.tra24Springboot.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Product extends BaseEntity {


    Integer quantity;
    String category;
    UUID sku;
    @OneToMany
    @Cascade(CascadeType.ALL)
    List<ProductDetails> productDetails;


}
