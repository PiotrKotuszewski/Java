package main.shop.Controller;

import main.shop.Model.Product;
import main.shop.Service.ProductService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Secured("OWNER")
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @Secured("OWNER")
    @PostMapping("/new")
    public String addProduct(@ModelAttribute Product product){
        return "redirect:/";
    }

    @GetMapping("/products")
    public String productList(Model model){
        model.addAttribute("allProducts", productService.showAllProducts());
        return "productsList";
    }

}
