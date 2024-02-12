package com.emart.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long customer;
    private List<OrderItem> orderItems;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;
}
