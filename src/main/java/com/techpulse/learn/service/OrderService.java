package com.techpulse.learn.service;

import com.techpulse.learn.entity.Order;
import com.techpulse.learn.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }

    public Order createOrder(Order order) {
        orderMapper.insertOrder(order);
        return order;
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = orderMapper.getOrderById(id);
        if (existingOrder == null) {
            return null;
        }
        order.setId(id);
        orderMapper.updateOrder(order);
        return orderMapper.getOrderById(id);
    }

    public boolean deleteOrder(Long id) {
        Order order = orderMapper.getOrderById(id);
        if (order == null) {
            return false;
        }
        orderMapper.deleteOrder(id);
        return true;
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderMapper.getOrdersByUserId(userId);
    }

    public long countOrders() {
        return orderMapper.countOrders();
    }

}
