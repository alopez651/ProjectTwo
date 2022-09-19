package com.revature.projectTwoTrial.Repository;

import com.revature.projectTwoTrial.Entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    // https://www.baeldung.com/spring-data-derived-queries <- syntax info
    List<CartEntity> findByName(String name);
    // finish this later when you have spring connected
    @Query(value = "SELECT * FROM cart where person_fk =?1", nativeQuery = true)
    public List<CartEntity> findMovies(Long owner_id);
}