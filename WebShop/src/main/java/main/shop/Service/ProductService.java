package main.shop.Service;

import main.shop.Model.Product;
import main.shop.Model.ShoppingCart;
import main.shop.Repository.ProductRepository;
import main.shop.Repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ProductService(ProductRepository productRepository, ShoppingCartRepository shoppingCartRepository) {
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getOneById(Long id){
        return productRepository.getById(id);
    }

    public void addToShoppingCart(ShoppingCart shoppingCart, Product product){
        if(!shoppingCart.getProductList().contains(product)){
            Set<Product> products = shoppingCart.getProductList();
            products.add(product);
            shoppingCart.setProductList(products);
            product.setShoppingCart(shoppingCart);

            shoppingCartRepository.save(shoppingCart);
            productRepository.save(product);
        }
    }

    public List<Product> showAllProducts(){
       return (List<Product>) productRepository.findAll();
    }
}
