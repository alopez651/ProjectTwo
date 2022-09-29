package com.revature.project.Service;

import com.revature.project.Entity.Product;
import com.revature.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@Service
public class ProductService {
    // injecting the repository bean into this class

    @Autowired
    ProductRepository productRepository;

    public Product insert(Product product){
        // inserting movie (cart) to the database
        productRepository.save(product);
        // return movie id, since we are generating
        return product;
    }
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

    // getting movie by id
    public Product getById(Long id){
        return productRepository.findById(id).get();
    }

    // getting all movies by list
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    // updating cart
    public Product update(Product product){
        productRepository.save(product);
        return product;
    }

    // deleting item (movie) from cart
    public void delete(Long id){
        productRepository.deleteById(id);
    }
//    public void add(Product product){
//        productRepository.save(product);
//    }


}