package main.shop.Controller;

import org.springframework.stereotype.Controller;
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
