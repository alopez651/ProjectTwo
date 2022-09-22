package com.revature.projectTwoTrial.Repository;

import com.revature.projectTwoTrial.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
