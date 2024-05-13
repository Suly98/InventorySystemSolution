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
    @OneToOne
    ProductDetails productDetails;

    @Override
    public String toString() {
        return "Product{" +
                "Product Name=" + productDetails.name +
                "Country of Origin= " + productDetails.countryOfOrigin+
                "quantity=" + quantity +
                ", category='" + category + '\'' +
                ", sku=" + sku +
                ", id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", isActive=" + isActive +
                '}';
    }
}
