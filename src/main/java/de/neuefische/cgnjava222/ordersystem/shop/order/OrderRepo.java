package de.neuefische.cgnjava222.ordersystem.shop.order;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class OrderRepo {

    private final Map<Integer, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.id(), order);
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

    public Order deleteOrder(Integer id) {
        return orders.remove(id);
    }
}
