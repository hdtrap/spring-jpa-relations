package ek.osnb.jpa.common.data;

import ek.osnb.jpa.orders.model.Order;
import ek.osnb.jpa.orders.model.OrderLine;
import ek.osnb.jpa.orders.model.OrderStatus;
import ek.osnb.jpa.orders.repository.OrderLineRepository;
import ek.osnb.jpa.orders.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public class InitData implements CommandLineRunner {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;

    public InitData(OrderRepository orderRepository, OrderLineRepository orderLineRepository) {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Order order1 = new Order(LocalDate.now(), OrderStatus.PAID);
        Order order2 = new Order(LocalDate.now(), OrderStatus.PAID);
        Order order3 = new Order(LocalDate.now(), OrderStatus.PAID);
        Order order4 = new Order(LocalDate.now(), OrderStatus.PAID);
        Order order5 = new Order(LocalDate.now(), OrderStatus.PAID);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);
        orderRepository.save(order5);
        // Or use orderRepository.saveAll(List.of(order1, order2));

        OrderLine orderLine1 = new OrderLine("Product A", 50.0, 2);
        OrderLine orderLine2 = new OrderLine("Product B", 30.0, 1);
        OrderLine orderLine3 = new OrderLine("Product C", 20.0, 5);
        OrderLine orderLine4 = new OrderLine("Product D", 15.0, 3);
        OrderLine orderLine5 = new OrderLine("Product E", 25.0, 4);

        // Add the relationship
        order1.addOrderLine(orderLine1);
        order2.addOrderLine(orderLine2);
        order3.addOrderLine(orderLine3);
        order4.addOrderLine(orderLine4);
        order5.addOrderLine(orderLine5);

        orderLineRepository.saveAll(List.of(orderLine1, orderLine2, orderLine3, orderLine4, orderLine5));
    }

}
