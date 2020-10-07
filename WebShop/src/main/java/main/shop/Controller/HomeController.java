package main.shop.Controller;

import main.shop.Repository.ProductRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Secured("ROLE_USER")
@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/order")
    @ResponseBody
    public String order(){
        return "order";
    }

}
