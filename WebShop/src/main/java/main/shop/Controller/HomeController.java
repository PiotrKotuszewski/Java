package main.shop.Controller;

import main.shop.Model.Product;
import main.shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
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

    @GetMapping("/products")
    public String productList(Model model){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Koszulka", "fajna", 500f, 5));
        products.add(new Product("Spodenki", "fajna", 50f, 5));
        products.add(new Product("Majtki", "fajna", 5f, 5));
        products.forEach(productRepository::save);
        List<Product> allProducts = (List<Product>) productRepository.findAll();
        model.addAttribute("allProducts", allProducts);
        return "productsList";
    }

}
