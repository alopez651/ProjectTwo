package com.revature.project.Controller;


//import com.revature.project.Entity.Cart;
import com.revature.project.Entity.Product;
import com.revature.project.Entity.Users;
import com.revature.project.Repository.UserRepository;
import com.revature.project.Service.UserService;
import org.apache.catalina.User;
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
    public Users auth(@RequestBody Users users, @RequestParam(value = "auth", required = true) String authType) {
        if (authType.equals("login"))
            return userService.login(users);
        else if (authType.equals("register"))
            return userService.register(users);
        else
            return null;
    }

    // sample request: localhost:/8080/people/1/pets/4
    // this shows that the user with its giving id is purchasing a movie with its giving id
    @PatchMapping("/{userId}/products/{productId}")
    //public Cart addToCart(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId, @RequestParam(value = "quantity", required = false) Integer quantity) {
    public Users addToCart(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {
        return userService.addToCart(userId, productId);////////// change
//        if(quantity == null){
//            quantity =1;
//        }
//        return userService.addToCart(userId, productId, quantity);

    }

    // returning movies to current user
    @GetMapping("/{userId}/products")
    public List<Product> getProduct(@PathVariable("userId") Long id) {
        return userService.getProduct(id);
    }

    //@CrossOrigin(origins = "*")
    @PutMapping()
    public Users update(@RequestBody Users users) {
        return userService.update(users);
    }

    // returning users history
    @GetMapping("/{userId}/products/{productId}")
    public List<Product> findMovies(@PathVariable("userId") Long userId) {
        return userService.findMovies(userId);
    }


    @CrossOrigin(origins = "*")
   @GetMapping("/{id}")
   public Users getById(@PathVariable("id" )Long id){
       return userService.getById(id);
   }


}