package com.scm.scm.services;

import com.scm.scm.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user) throws Exception;

    Optional<User> getUserById(Long id) throws Exception;

    Optional<User>  updateUser(User user) throws Exception;

    void deleteUser(Long id) throws Exception;
    boolean isUserExist(Long userId) throws Exception;
    boolean isUserExistByUserName(String email) throws Exception;
    Optional<List<User>> getAllUsers() throws Exception;

}
