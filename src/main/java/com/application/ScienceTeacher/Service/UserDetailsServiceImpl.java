package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Entity.UserPrincipal;
import com.application.ScienceTeacher.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUserName(username);
        if (user == null) {
            log.error("User found by username: " + username + " not found");
            throw  new RuntimeException("UserName is Invalid");
        }

        log.info("User found by username: " + username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;

    }
}
