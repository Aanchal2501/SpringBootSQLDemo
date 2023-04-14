package com.sql.example.SpringBootSQLDemo.Service;

import com.sql.example.SpringBootSQLDemo.Collections.Product;
import com.sql.example.SpringBootSQLDemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> productList) {
        return repository.saveAll(productList);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductbyId(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductbyName(String name) {
        return repository.findByName(name);
    }
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed || "+id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }
}
