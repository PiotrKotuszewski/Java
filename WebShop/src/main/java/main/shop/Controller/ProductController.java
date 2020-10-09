package main.shop.Controller;

import main.shop.Model.Product;
import main.shop.Model.ShoppingCart;
import main.shop.Service.ProductService;
import main.shop.Service.ShoppingCartService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;

    public ProductController(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
    }

    @Secured("ROLE_OWNER")
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @Secured("ROLE_OWNER")
    @PostMapping("/new")
    public String addProduct(@ModelAttribute Product product){
        product.setDetails(null);
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String productList(Model model){
        System.out.println(productService.showAllProducts().get(0));
        model.addAttribute("allProducts", productService.showAllProducts());
        return "productsList";
    }

    @GetMapping("/productDetails")
    public String productDetails(Long Id, Model model){
        model.addAttribute("product", productService.getOneById(Id));
        return "productDetails";
    }

    @GetMapping("/add")
    public String addProductToShoppingCart(Long Id, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        String userId = principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject();
        Product product = productService.getOneById(Id);
        if(shoppingCartService.getOneById(userId) != null){
            productService.addToShoppingCart(shoppingCartService.getOneById(userId), product);
        }else {
            ShoppingCart shoppingCart = new ShoppingCart(userId, new HashSet<>());
            productService.addToShoppingCart(shoppingCart, product);
        }

        return "redirect:/shoppingCart/show";
    }
}
