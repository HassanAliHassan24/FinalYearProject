package com.application.ScienceTeacher.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "Teacher")
public class Teacher extends User{
    private String service_type;
    private String education_level;
//    private String certificate_type;
    private String certificate_released_date;



//    @OneToMany(mappedBy = "teacher")
//    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "teacher")
    private List<Rating> ratings;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany
    @JoinTable(name = "Program_Teacher",
    joinColumns = @JoinColumn (name = "program_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Program> programs;
    

}
