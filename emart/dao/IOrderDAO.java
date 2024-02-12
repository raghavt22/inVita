package com.emart.dao;

import java.util.List;

import com.emart.entities.Order;
import com.emart.entities.OrderStatus;

public interface IOrderDAO {

	 Order saveOrder(Order order);
	 List<Order> getAllOrders();
	 Order getOrderById(Long id);
	// List<Order> getOrdersByCustomerId(Long customerId);
	 void deleteOrderById(Long id);
	 void updateOrderStatus(Long id, OrderStatus status);
}
