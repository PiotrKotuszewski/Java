package main.shop.Controller;

import main.shop.Model.Order;
import main.shop.Model.ShoppingCart;
import main.shop.Model.User;
import main.shop.Repository.OrderRepository;
import main.shop.Repository.UserRepository;
import main.shop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/order")
public class OrderController {
/*
    private UserRepository userRepository;
    private OrderService orderService;
    private User user;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String home(Model model){
        model.addAttribute("order", new Order());
        return "order";
    }

    @PostMapping("/save")
    public String addOrder(@ModelAttribute Order order){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user = userRepository.findByEmail(((UserDetails) auth.getPrincipal()).getUsername());
        order.setPostDate("aaaa");
        order.setOrderSum(5000f);
        System.out.println(order.toString());
        orderService.addOrder(order, user, new ShoppingCart());

        return "redirect:/";
    }*/
}
