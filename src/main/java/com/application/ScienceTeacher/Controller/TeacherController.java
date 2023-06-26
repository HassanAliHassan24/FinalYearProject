package com.application.ScienceTeacher.Controller;
import com.application.ScienceTeacher.Entity.Teacher;
import com.application.ScienceTeacher.Repository.TeacherRepository;
import com.application.ScienceTeacher.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    public TeacherService teacherService;
    @Autowired
    public TeacherRepository teacherRepository;

    @PostMapping("/register")
    public Teacher registerTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.registerTeacher(teacher);

    }
    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return this.teacherService.addTeacher(teacher);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        List<Teacher> teachers = this.teacherService.getAllTeacher();

        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("userId") Integer id) {
        Teacher teacher = this.teacherService.getById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);

    }
    @Transactional
    @DeleteMapping("/deleteTeacher/{id}")
    public void deleteTeacherById(@PathVariable Integer id){
        this.teacherService.deleteTeacherById(id);
    }

    @PutMapping("/updateTeacher/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return this.teacherService.updateTeacher(teacher);
    }
}
