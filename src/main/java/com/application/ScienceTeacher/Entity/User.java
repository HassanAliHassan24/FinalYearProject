package com.application.ScienceTeacher.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String address;
    private String gender;
    private String phoneNumber;
    private  String userName ;
    private String password;
    private String roles;


//    public int getAge() {
//        return Period.between(dob,LocalDate.now()).getYears();
//    }

//    public void setAge(int age) {
//        this.age = age;
//    }
//


}
