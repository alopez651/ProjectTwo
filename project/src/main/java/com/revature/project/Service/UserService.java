package com.revature.project.Service;

import com.revature.project.Entity.Product;
import com.revature.project.Entity.User;
import com.revature.project.Repository.ProductRepository;
import com.revature.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
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

    public User login(User users){
        // check if this is okay instead of username
//        User uDB = userRepository.findById(user.getUsername()).get();
        User uDB = userRepository.findById(users.getId()).get();
        if(users.getPassword().equals(uDB.getPassword()))
            return uDB;
        else
            return null;
    }

    public User addToCart(Long userId, Long movieId){
        //public User addToCart(Long userId, Long movieId){
        Product product = productRepository.findById(movieId).get();
        User users = userRepository.findById(userId).get();

        // updating users Cart
        users.addToCart(product);

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