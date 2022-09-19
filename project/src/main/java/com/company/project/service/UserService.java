package com.company.project.service;

import com.company.project.entity.User;
import com.company.project.entity.Product;
import com.company.project.repository.UserRepository;
import com.company.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


    public List<Product> findPurshasedMovies(Long userId) {
        User user = userRepository.findById(userId).get();
        return user.getMovies();
    }
    public User  findInfo(Long userId){
        User user = userRepository.findById(userId).get();
        return user;
    }
}

