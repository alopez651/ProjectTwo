package com.revature.projectTwoTrial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity

public class UserEntity {
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
    @OneToMany(targetEntity = CartEntity.class, cascade = CascadeType.ALL)
    // setting the column in the past table
    @JoinColumn(name = "person_fk", referencedColumnName = "id")
    private List<CartEntity> addCart;

    public UserEntity(){
        // empty list
        addCart = new ArrayList<>();
    }

    public void addToCart(CartEntity cart) {
        addCart.add(cart);
    }
}
