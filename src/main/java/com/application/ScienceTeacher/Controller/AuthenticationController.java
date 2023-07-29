package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Entity.UserPrincipal;
import com.application.ScienceTeacher.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public User login (@RequestBody User user){
        authenticateUser(user.getUserName(), user.getPassword());
        User loginUser = userRepository.findUserByUserName(user.getUserName());
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return loginUser;
    }

    private void authenticateUser(String userName, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
    }
}
