package main.shop.Service;

import main.shop.Model.Order;
import main.shop.Model.ShoppingCart;
import main.shop.Model.User;
import main.shop.Repository.OrderRepository;
import main.shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private List<Order> orders = new ArrayList<>();

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addOrder(Order order, User user, ShoppingCart shoppingCart){
        if(!orders.contains(order)) {
            orders.add(order);
            order.setUser(user);
            order.setShoppingCart(shoppingCart);
            user.setOrders(orders);
            orderRepository.save(order);
            userRepository.save(user);
        }
    }
}
