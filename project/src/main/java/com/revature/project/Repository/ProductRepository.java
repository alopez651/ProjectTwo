package com.revature.project.Repository;

import com.revature.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // https://www.baeldung.com/spring-data-derived-queries <- syntax info
    List<Product> findByName(String name);
    // finish this later when you have spring connected
    @Query(value = "SELECT * FROM product where person_fk =?1", nativeQuery = true)
    public List<Product> findAddProduct(Long owner_id);

    //Mosaab you already have it so am gonna use your meyhod [findMovies]
    // @Query(value = "SELECT * FROM product where user_fk = ?1", nativeQuery = true)
    // public List<Product> findPurchasedMovies(Long Owner_id);
}