package com.revature.projectTwoTrial.Service;

import com.revature.projectTwoTrial.Entity.CartEntity;
import com.revature.projectTwoTrial.Repository.CartRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    // injecting the repository bean into this class

    @Autowired
    CartRepository cartRepository;

    public CartEntity insert(CartEntity cart){
        // inserting movie (cart) to the database
        cartRepository.save(cart);
        // return movie id, since we are generating
        return cart;
    }
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

    // getting movie by id
    public CartEntity getById(Long id){
        return cartRepository.findById(id).get();
    }

    // getting all movies by list
    public List<CartEntity> getAll(){
        return cartRepository.findAll();
    }

    // updating cart
    public CartEntity update(CartEntity cart){
        cartRepository.save(cart);
        return cart;
    }

    // deleting item (movie) from cart
    public void delete(Long id){
        cartRepository.deleteById(id);
    }

}
