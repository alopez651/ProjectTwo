package com.company.project.controller;

import com.company.project.entity.User;
import com.company.project.entity.Product;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("/{userId}/products/{productId}")
    public List<Product> findPreviouslyPurshasedMovies(@PathVariable("userId") Long userId) {
        return userService.findPurshasedMovies(userId);
    }

    @GetMapping("/{id}/")
    public List<Product> findPurshasedMovies(@PathVariable("id") Long id) {
        return userService.get(id);
    }

}
