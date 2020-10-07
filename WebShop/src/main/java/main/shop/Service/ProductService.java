package main.shop.Service;

import main.shop.Model.Product;
import main.shop.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> showAllProducts(){
       return (List<Product>) productRepository.findAll();
    }
}
