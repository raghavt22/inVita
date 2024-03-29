package com.emart.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "customer_id", nullable = false)
	    @JsonBackReference
	    private Customer customer;
	    
	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	    private List<OrderItem> orderItems;
	    
	    @Column(nullable = false)
	    private LocalDateTime orderDate;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private OrderStatus status;
	    
	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal totalAmount;
}
