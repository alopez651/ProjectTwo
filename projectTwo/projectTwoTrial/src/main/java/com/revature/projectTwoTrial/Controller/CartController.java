package com.revature.projectTwoTrial.Controller;

import com.revature.projectTwoTrial.Entity.CartEntity;
import com.revature.projectTwoTrial.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService cartService;

    // inserting movie to cart
    @PostMapping()
    public CartEntity insert(@RequestBody CartEntity cart){
        return cartService.insert(cart);
    }

    // getting all movies
    @GetMapping()
    public List<CartEntity> getAll(){
        return cartService.getAll();
    }

    // getting movie by default id
    // https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/
    @GetMapping("/{id}")
    public CartEntity getById(@PathVariable("id" )Long id){
        return cartService.getById(id);
    }

    // updating cart
    @PutMapping()
    public CartEntity update(@RequestBody CartEntity cart){
        return cartService.update(cart);
    }

    // deleting item from cart
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        cartService.delete(id);
    }
}
