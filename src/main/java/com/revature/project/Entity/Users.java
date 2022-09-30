package com.revature.project.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@NoArgsConstructor
@AllArgsConstructor
@Data
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

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
   // @OneToMany(targetEntity = Cart.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "users_fk", referencedColumnName = "id")
    private List<Product> addProduct, products;


//, products
    public Users (){
        this.addProduct = new ArrayList<>();
        this.products = new ArrayList<>();
    }
}
