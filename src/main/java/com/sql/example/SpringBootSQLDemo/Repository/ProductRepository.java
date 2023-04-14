package com.sql.example.SpringBootSQLDemo.Repository;

import com.sql.example.SpringBootSQLDemo.Collections.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
