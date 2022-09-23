package com.revature.project.Controller;


import com.revature.project.Entity.Product;
import com.revature.project.Entity.Users;
import com.revature.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    // needs to be true to guarantee that we need a request paramater with the key 'auth'
    public Users auth(@RequestBody Users users, @RequestParam(value = "auth", required = true) String authType){
        if (authType.equals("login"))
            return userService.login(users);
        else if (authType.equals("register"))
            return userService.register(users);
        else
            return null;
    }
    // sample request: localhost:/8080/people/1/pets/4
    // this shows that the user with its giving id is purchasing a movie with its giving id
    @PatchMapping("/{userId}/products/{movieId}")
    public Users addToCart(@PathVariable("userId") Long userId, @PathVariable("movieId") Long movieId){
        //public Users addToCart(@PathVariable("userId") Long userId, @PathVariable("movieId") Long movieId){
        return userService.addToCart(userId, movieId);
    }

    // returning movies to current user
    @GetMapping("/{userId}/products")
    public List<Product> getMovies(@PathVariable("userId") Long id){
        return userService.getMovies(id);
    }
}
