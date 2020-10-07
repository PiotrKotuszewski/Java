package main.shop.Controller;

import main.shop.Model.Product;
import main.shop.Model.ShoppingCart;
import main.shop.Service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private List<Product> productList = new ArrayList<>();

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/show")
    public String home(Model model){
        ShoppingCart shoppingCart = new ShoppingCart();
        productList.add(new Product("Jajko", "costam", 1f, 500));
        productList.add(new Product("Jablko", "costam", 3f, 100));
        productList.add(new Product("Ser", "costam", 2f, 50));
        shoppingCartService.addShoppingCart(shoppingCart, productList);
        model.addAttribute("shoppingCart", new ShoppingCart());
        return "shoppingCart";
    }




}
