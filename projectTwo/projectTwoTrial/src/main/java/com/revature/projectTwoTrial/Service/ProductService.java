package com.revature.projectTwoTrial.Service;

import com.revature.projectTwoTrial.Entity.Product;
import com.revature.projectTwoTrial.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "*")
@Service
public class ProductService {
    // injecting the repository bean into this class

    @Autowired
    ProductRepository productRepository;

    public Product insert(Product cart){
        // inserting movie (cart) to the database
        productRepository.save(cart);
        // return movie id, since we are generating
        return cart;
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
    public Product update(Product cart){
        productRepository.save(cart);
        return cart;
    }

    // deleting item (movie) from cart
    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
