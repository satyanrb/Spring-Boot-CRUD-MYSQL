package com.javatachie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatachie.crud.example.entity.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

	Product findByName(String name);
}
