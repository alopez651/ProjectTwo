package com.revature.project.Service;

//import com.revature.project.Entity.Cart;
import com.revature.project.Entity.Product;
import com.revature.project.Entity.Users;
import com.revature.project.Repository.ProductRepository;
import com.revature.project.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Calendar;
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
//        Users uDB;
//        try{
//            uDB = userRepository.findById(users.getId()).get();
//            if(!users.getPassword().equals(uDB.getPassword()))
//                return null;
//        } catch(NoSuchElementException e){
//            return null;
//        }   return uDB;
        Users uDB;
        try{
            uDB = userRepository.findByUsername(users.getUsername());
            if(!users.getPassword().equals(uDB.getPassword()))
                return null;
        } catch (NoSuchElementException e){
            return null;
        }
        return uDB;
    }
//    public Users getById(Long id){
//        return userRepository.findById(id).get();
//    }

    public Users addToCart(Long userId, Long productId){

        Product product = productRepository.findById(productId).get();

        Users users = userRepository.findById(userId).get();

        users.getAddProduct().add(product);

        userRepository.save(users);
        return users;
    }

    // return movies to current users id
    public List<Product> getProduct(Long userId){
        return productRepository.findAddProduct(userId);
    }


    //Mosaab return history of products purchased for a user "not sure if it is correct
    public List<Product> findMovies(Long userId) {
        Users user = userRepository.findById(userId).get();
        return user.getProducts();
    }
//    //Mosaab update user profile

    public Users update(Users users) {
        userRepository.save(users);
        return users;
    }


//    public Users getById(Users users){
//        Users up;
//        try{
//            up = userRepository.findById(users.getId()).get();
//        } catch (NoSuchElementException e){
//            return null;
//        }
//        return up;
//    }
//

    public Users getById(Long id) {
        return userRepository.findById(id).get();
    }

}
// https://dzone.com/articles/how-to-get-current-logged-in-username-in-spring-se