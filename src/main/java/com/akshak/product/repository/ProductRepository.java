package com.akshak.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshak.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
