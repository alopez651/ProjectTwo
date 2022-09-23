package com.revature.project.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Users {
    @Id
    @GeneratedValue

    private long id;
    private String name;
    private String lastName;
    // to make sure that users to have the same username
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    // setting up relationship between cart and user
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    // setting the column in the past table
    @JoinColumn(name = "person_fk", referencedColumnName = "id")
    // @JoinColumn(name = "person_fk", referencedColumnName = "id")
    private List<Product> addProduct;

    public Users(){
        // empty list
        addProduct = new ArrayList<>();
    }

    public void addToCart(Product product) {
        addProduct.add(product);
    }
}
