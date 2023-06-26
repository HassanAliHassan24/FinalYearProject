//package com.application.ScienceTeacher.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Qualification {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int qualification_Id;
//    private String certificate_name;
//    private String certificate_type;
//    private String certificate_released_date;
//
//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Teacher teacher;
//
//
//}
