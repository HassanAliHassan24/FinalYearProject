package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Repository.UserRepository;
import com.application.ScienceTeacher.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        if (userRepository.existsByuserName(user.getUserName())){
            throw new IllegalArgumentException("userName already axists");
        }
        return this.userService.addUser(user);
    }



    @GetMapping("/getAll")
   public ResponseEntity<List<User>> getAllUser(){
        List<User> users = this.userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping("/getById/{id}")
   public ResponseEntity<User> getUserById(@PathVariable ("UserId")Integer id){
        User user = this.userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
   }

   @Transactional
   @DeleteMapping("/deleteUser/{id}")
   public void deleteUserById(@PathVariable Integer id){
        this.userService.deleteUserById(id);
   }
   @PutMapping("/updateUser/{id}")
   public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
   }
}
