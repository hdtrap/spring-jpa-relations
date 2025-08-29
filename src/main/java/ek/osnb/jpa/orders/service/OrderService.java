package ek.osnb.jpa.orders.service;


import ek.osnb.jpa.orders.model.Order;
import ek.osnb.jpa.orders.model.OrderStatus;
import ek.osnb.jpa.orders.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders(OrderStatus status);
    Order getOrderById(Long id);
    Order createOrder(Order order);
    public Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
