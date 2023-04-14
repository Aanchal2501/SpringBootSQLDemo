package com.sql.example.SpringBootSQLDemo.Controller;

import com.sql.example.SpringBootSQLDemo.Collections.Product;
import com.sql.example.SpringBootSQLDemo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> productList) {
        return service.saveProducts(productList);
    }

    @GetMapping("/getProducts")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productbyId")
    public Product findProductById(@RequestParam int id) {
        return service.getProductbyId(id);
    }

    @GetMapping("/productByName")
    public Product findProductByName(@RequestParam String name) {
        return service.getProductbyName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
