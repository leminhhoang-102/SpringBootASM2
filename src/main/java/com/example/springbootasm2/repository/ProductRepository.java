package com.example.springbootasm2.repository;

import com.example.springbootasm2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
