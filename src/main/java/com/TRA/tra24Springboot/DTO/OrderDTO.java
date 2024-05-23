package com.TRA.tra24Springboot.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    String categoryNameDTO;
    Date orderedDateDTO
    List<ProductDTO> productsOrderedDTO;

}
