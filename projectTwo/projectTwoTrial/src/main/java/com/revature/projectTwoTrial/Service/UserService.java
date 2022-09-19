package com.revature.projectTwoTrial.Service;

import com.revature.projectTwoTrial.Entity.CartEntity;
import com.revature.projectTwoTrial.Entity.UserEntity;
import com.revature.projectTwoTrial.Repository.CartRepository;
import com.revature.projectTwoTrial.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    public UserEntity register(UserEntity users){
        userRepository.save(users);
        return users;
    }

    public UserEntity login(UserEntity user){
        // check if this is okay instead of username
        UserEntity uDB = userRepository.findById(user.getId()).get();
        if(user.getPassword().equals(uDB.getPassword()))
            return uDB;
        else
            return null;
    }

    public UserEntity addToCart(Long userId, Long movieId){
        CartEntity cart = cartRepository.findById(movieId).get();
        UserEntity users = userRepository.findById(userId).get();

        // updating users Cart
        users.addToCart(cart);

        // persist this change to the database
        userRepository.save(users);
        return users;
    }

    // return movies to current users id
    public List<CartEntity> getMovies(Long userId){
        return cartRepository.findMovies(userId);
    }



}
// https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se
