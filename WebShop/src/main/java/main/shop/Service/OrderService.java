package main.shop.Service;

import main.shop.Model.Order;
import main.shop.Model.ShoppingCart;
import main.shop.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private List<Order> orders = new ArrayList<>();

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order, ShoppingCart shoppingCart){
        if(!orders.contains(order)) {
            orders.add(order);
            order.setShoppingCart(shoppingCart);
            orderRepository.save(order);
        }
    }
}
