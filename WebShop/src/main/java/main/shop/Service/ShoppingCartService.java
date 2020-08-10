package main.shop.Service;

import main.shop.Model.Product;
import main.shop.Model.ShoppingCart;
import main.shop.Model.User;
import main.shop.Repository.ProductRepository;
import main.shop.Repository.ShoppingCartRepository;
import main.shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setShoppingCartRepository(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addShoppingCart(ShoppingCart shoppingCart, List<Product> products){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(((UserDetails) auth.getPrincipal()).getUsername());
        products.forEach(productRepository::save);
        shoppingCart.setProductList(products);
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }
}
