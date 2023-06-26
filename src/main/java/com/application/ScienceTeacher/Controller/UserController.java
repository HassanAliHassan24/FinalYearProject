package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Repository.UserRepository;
import com.application.ScienceTeacher.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @GetMapping("/getAll")
   public ResponseEntity<List<User>> getAllUser(){
        List<User> users = this.userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
   }

   @GetMapping("/getById/{UserId}")
   public ResponseEntity<User> getUserById(@PathVariable ("UserId")Integer UseId){
        User user = this.userService.getById(UseId);
        return new ResponseEntity<>(user, HttpStatus.OK);
   }
   @Transactional
   @DeleteMapping("/deleteUser/{UserId}")
   public void deleteUserById(@PathVariable Integer UserId){
        this.userService.deleteUserById(UserId);
   }
   @PutMapping("/updateUser/{UserId}")
   public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
   }
}
