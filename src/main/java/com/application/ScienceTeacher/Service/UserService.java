package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        String encPsd = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encPsd);
        user.setRoles("ROLE_USER".toUpperCase());
        return this.userRepository.save(user);

    }


    public User addUser(User user){
        String encPsd = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encPsd);
        return this.userRepository.save(user);

    }


    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

    public User getById(Integer id){
        return this.userRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("That"+ id+"NotFound"));
    }

    public void deleteUserById(Integer UserId){
        this.userRepository.deleteById(UserId);
    }



    public User updateUser(User user){
        String encPsd = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encPsd);
        User user1 = this.userRepository.findById(user.getId()).orElseThrow();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAge(user.getAge());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setGender(user.getGender());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());
        return this.userRepository.save(user1);
    }
}
