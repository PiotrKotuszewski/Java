package main.shop.Service;

import main.shop.Model.Product;
import main.shop.Model.ShoppingCart;
import main.shop.Repository.ProductRepository;
import main.shop.Repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    public void addShoppingCart(ShoppingCart shoppingCart, Set<Product> products){
        products.forEach(productRepository::save);
        shoppingCart.setProductList(products);
        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart getOneById(String userId){
        return shoppingCartRepository.getByUserId(userId);
    }

}
