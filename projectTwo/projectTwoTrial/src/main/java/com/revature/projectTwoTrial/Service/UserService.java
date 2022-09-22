package com.revature.projectTwoTrial.Service;

import com.revature.projectTwoTrial.Entity.Product;
import com.revature.projectTwoTrial.Entity.User;
import com.revature.projectTwoTrial.Repository.ProductRepository;
import com.revature.projectTwoTrial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public User register(User users){
        userRepository.save(users);
        return users;
    }

    public User login(User user){
        // check if this is okay instead of username
//        User uDB = userRepository.findById(user.getUsername()).get();
        User uDB = userRepository.findById(user.getId()).get();
        if(user.getPassword().equals(uDB.getPassword()))
            return uDB;
        else
            return null;
    }

    public User addToCart(Long userId, Long movieId){
        //public User addToCart(Long userId, Long movieId){
        Product cart = productRepository.findById(movieId).get();
        User users = userRepository.findById(userId).get();

        // updating users Cart
        users.addToCart(cart);

        // persist this change to the database
        userRepository.save(users);
        return users;
    }

    // return movies to current users id
    public List<Product> getMovies(Long userId){
        return productRepository.findMovies(userId);
    }



}
// https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se
