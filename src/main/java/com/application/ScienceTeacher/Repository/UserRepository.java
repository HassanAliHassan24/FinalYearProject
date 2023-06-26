package com.application.ScienceTeacher.Repository;

import com.application.ScienceTeacher.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByUserName (String userName);


}
