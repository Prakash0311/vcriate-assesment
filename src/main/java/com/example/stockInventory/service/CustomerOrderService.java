package com.example.stockInventory.service;

import com.example.stockInventory.entity.CustomerOrder;
import com.example.stockInventory.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository orderRepository;

    public CustomerOrder createOrder(CustomerOrder order) {
        return orderRepository.save(order);
    }

    public CustomerOrder updateOrder(Long id, CustomerOrder updatedOrder) {
        Optional<CustomerOrder> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            CustomerOrder order = existingOrder.get();
            order.setCustomerId(updatedOrder.getCustomerId());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setStatus(updatedOrder.getStatus());
            return orderRepository.save(order);
        }
        return null;
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public CustomerOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
