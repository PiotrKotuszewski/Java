package main.shop.Service;

import main.shop.Model.Product;
import main.shop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }
}
