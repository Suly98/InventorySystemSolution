package com.TRA.tra24Springboot.InvoiceRepositories;

import com.TRA.tra24Springboot.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("SELECT i FROM Product i WHERE i.id =:id")
    Product getProductById(@Param("id") Integer id);

}
