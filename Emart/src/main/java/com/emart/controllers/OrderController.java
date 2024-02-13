package com.emart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.dao.IOrderDAO;
import com.emart.entities.Order;
import com.emart.entities.OrderDTO;

@RestController
public class OrderController {

		@Autowired
		private IOrderDAO orderDAO;
		
//		@GetMapping("/orders")
//		public ResponseEntity<List<Order>> getAllOrders() {
//			return ResponseEntity.ok(orderDAO.getAllOrders());
//	    }
		
		@GetMapping("/orders")
		public ResponseEntity<?> getAllOrders() {
			List<OrderDTO> orderDTOList  = new ArrayList<>();
			List<Order> allOrders = orderDAO.getAllOrders();
			for(var item: allOrders) {
				OrderDTO orderDTO = new OrderDTO();
				BeanUtils.copyProperties(item,orderDTO);
				orderDTOList.add(orderDTO);
			}
			return ResponseEntity.ok(orderDTOList);
	    }
		
//		@GetMapping("/orders/{orderId}")
//		public ResponseEntity<?> getOrderById(@PathVariable("orderId") Long id){
//			orderDTO = new OrderDTO();
//			Order orderById = orderDAO.getOrderById(id);
//			orderDTO.setId(orderById.getId());
//			BeanUtils.copyProperties(orderById,orderDTO);
//			return ResponseEntity.ok(orderDTO);
//		}
}
