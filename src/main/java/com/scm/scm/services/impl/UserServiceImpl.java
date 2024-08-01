package com.scm.scm.services.impl;

import com.scm.scm.exception.ResourceNotFoundException;
import com.scm.scm.helper.AppConstant;
import com.scm.scm.model.User;
import com.scm.scm.repository.UserRepo;
import com.scm.scm.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) throws Exception {
//        user.setUserId(user.getUserId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole_list(List.of(AppConstant.ROLE_USER));
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) throws Exception {
        try {
            logger.info("Fetching user by ID: {}", id);
            return userRepo.findById(id);
        } catch (Exception e) {
            logger.error("Error fetching user by ID: {}", e.getMessage());
            throw new Exception("Error fetching user by ID", e);
        }
    }

    @Override
    public Optional<User> updateUser(User user) throws Exception {
        User userToUpdate = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword()); // Update password if necessary
        userToUpdate.setAbout(user.getAbout());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        userToUpdate.setProfilePic(user.getProfilePic());
        userToUpdate.setEnabled(user.isEnabled());
        userToUpdate.setEmailVerified(user.isEmailVerified());
        userToUpdate.setPhoneVerified(user.isPhoneVerified());
        userToUpdate.setProvider(user.getProvider());
        userToUpdate.setProviderUserId(user.getProviderUserId());


        User updatedUser = userRepo.save(userToUpdate);

        return Optional.of(updatedUser);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user2=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        userRepo.delete(user2);

    }

    @Override
    public boolean isUserExist(Long userId) throws Exception {
//       User user2=userRepo.findById(userId).orElse(null);
//       return user2 !=null ?true:false;
        return userRepo.findById(userId).isPresent();
    }

    @Override
    public boolean isUserExistByUserName(String email) throws Exception {
//         User user=userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("user email not exists"));
//         return user!=null?true:false;
        return userRepo.findByEmail(email).isPresent();

    }

    @Override
    public Optional<List<User>> getAllUsers() throws Exception {
        try {
            logger.info("Fetching all users");
            return Optional.of(userRepo.findAll());
        } catch (Exception e) {
            logger.error("Error fetching all users: {}", e.getMessage());
            throw new Exception("Error fetching all users", e);
        }
    }
}
