package com.application.ScienceTeacher;

import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ScienceTeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScienceTeacherApplication.class, args);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println(passwordEncoder.encode("123"));
	}


//	@Bean
public User addAdmin(UserRepository userRepository) {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	User admin = new User();
	admin.setFirstName("Hassan");
	admin.setLastName("Ali");
	admin.setAddress("Magomeni");
	admin.setAge(26);
	admin.setRoles("ROLE_ADMIN");
	admin.setPhoneNumber("+255774661603");
	admin.setGender("Male");
	admin.setEmail("hassanrami922@mail.com");
	admin.setUserName("Admin");
	admin.setPassword(passwordEncoder.encode("Admin123"));

	userRepository.save(admin);
	return admin;
}


}
