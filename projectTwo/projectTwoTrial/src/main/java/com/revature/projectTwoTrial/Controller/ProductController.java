package com.revature.projectTwoTrial.Controller;

import com.revature.projectTwoTrial.Entity.Product;
import com.revature.projectTwoTrial.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carts")
public class ProductController {

    @Autowired
    ProductService productService;

    // inserting movie to cart
    @PostMapping()
    public Product insert(@RequestBody Product cart){
        return productService.insert(cart);
    }

    // getting all movies
    @GetMapping()
    public List<Product> getAll(){
        return productService.getAll();
    }

    // getting movie by default id
    // https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/
    @GetMapping("/{id}")
    public Product getById(@PathVariable("id" )Long id){
        return productService.getById(id);
    }

    // updating cart
    @PutMapping()
    public Product update(@RequestBody Product cart){
        return productService.update(cart);
    }

    // deleting item from cart
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
