package com.techpulse.learn.mapper;

import com.techpulse.learn.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    Order getOrderById(@Param("id") Long id);

    List<Order> getAllOrders();

    void insertOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(@Param("id") Long id);

    List<Order> getOrdersByUserId(@Param("userId") Long userId);

    long countOrders();

}
