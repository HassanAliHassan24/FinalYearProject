package com.application.ScienceTeacher.Repository;

import com.application.ScienceTeacher.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByuserName(String userName);


    User findUserByUserName (String userName);


    Optional<Object> findByRoles(String roles);
}
