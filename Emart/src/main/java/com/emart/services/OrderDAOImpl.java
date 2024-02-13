package com.emart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emart.dao.IOrderDAO;
import com.emart.entities.Order;
import com.emart.entities.OrderStatus;
import com.emart.repository.OrderRepository;

@Service
public class OrderDAOImpl implements IOrderDAO {
	

	@Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
            return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

	/*
	 * public List<Order> getOrdersByCustomerId(Long customerId) { return
	 * orderRepository.findByCustomerId(customerId); }
	 */

    public void deleteOrderById(Long id) {
    	Order o = orderRepository.findById(id).get();
		if(o!=null)
		{
			orderRepository.delete(o);
		}
    }

    public void updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            orderRepository.save(order);
        }
    }
}
