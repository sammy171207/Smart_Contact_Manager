package com.scm.scm.repository;

import com.scm.scm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    List<User> findByEnabled(boolean enabled);
    List<User> findByNameContaining(String namePart);
}
