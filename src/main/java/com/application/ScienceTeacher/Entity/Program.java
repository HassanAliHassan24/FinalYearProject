package com.application.ScienceTeacher.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Program")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int program_id;
    private String program_name;
    private  String duration;
    private String prerequisite;


    @ManyToMany(mappedBy = "programs")
    private List<Teacher> teacherList;


}
