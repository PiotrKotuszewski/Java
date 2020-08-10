package main.shop.Controller;

import main.shop.Model.Product;
import main.shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;
    private List<Product> productList = new ArrayList<>();

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String home(Model model){
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute Product product){

        return "redirect:/";
    }
}
