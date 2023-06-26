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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location_id;
    private String location_name;

    @OneToMany(mappedBy = "location")
    private List<Teacher> teachers;
}
