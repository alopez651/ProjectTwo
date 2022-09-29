package com.revature.project.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

// users should be able to add carts to later purchase
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int releaseYear;
    private int user_id;
    private int ratings;
    private String description;

   // private List<Users> list;

//
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<ProductCart> productCartList;
}
