package com.company.project.service;

import com.company.project.entity.Product;
import com.company.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Product> getAll() {
        return productRepository.findAll();
    }


}

