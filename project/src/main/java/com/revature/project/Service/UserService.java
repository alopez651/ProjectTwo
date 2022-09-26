package com.revature.project.Service;

import com.revature.project.Entity.Product;
import com.revature.project.Entity.Users;
import com.revature.project.Repository.ProductRepository;
import com.revature.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public Users register(Users users){
        userRepository.save(users);
        return users;
    }

    public Users login(Users users){
        // check if this is okay instead of username
//        Users uDB = userRepository.findById(user.getUsername()).get();
//        Users uDB = userRepository.findById(users.getId()).get();
//        if(users.getPassword().equals(uDB.getPassword()))
//            return uDB;
//        else
//            return null;
        Users uDB;
        try{
            uDB = userRepository.findById(users.getId()).get();
            if(!users.getPassword().equals(uDB.getPassword()))
                return null;
        } catch(NoSuchElementException e){
            return null;
        }   return uDB;
    }

    public Users addToCart(Long userId, Long productId){
        //public Users addToCart(Long userId, Long movieId){
        Product product = productRepository.findById(productId).get();
        Users users = userRepository.findById(userId).get();

        // updating users Cart
        //users.addToCart(product);
        users.getAddProduct().add(product);
        // persist this change to the database
        userRepository.save(users);
        return users;
    }

    // return movies to current users id
    public List<Product> getProduct(Long userId){
        return productRepository.findAddProduct(userId);
    }


    //Mosaab return history of products purchased for a user "not sure if it is correct
    public List<Product> findPurchasedProducts(Long userId) {
        Users user = userRepository.findById(userId).get();
        return user.getProducts();
    }
//    //Mosaab update user profile
    public Users update(Users users) {
        userRepository.save(users);
        return users;
    }


}
// https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se