package com.application.ScienceTeacher.Service;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.application.ScienceTeacher.Entity.Teacher;
import com.application.ScienceTeacher.Entity.User;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.TeacherRepository;
import com.application.ScienceTeacher.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    public TeacherRepository teacherRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository userRepository;

    public Teacher registerTeacher(Teacher teacher) {
        String encPsd = this.passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encPsd);
        teacher.setRoles("ROLE_TEACHER".toUpperCase());
        return this.teacherRepository.save(teacher);

    }

    public Teacher addTeacher(Teacher teacher) {
        String encPsd = this.passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encPsd);
        return this.teacherRepository.save(teacher);

    }

    public List<Teacher> getAllTeacher() {

        return this.teacherRepository.findAll();
    }

    public Teacher getById(Integer id) {
        return (Teacher) this.teacherRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ThatId" + id + "NotFound"));

    }

    public void deleteTeacherById(Integer id) {

        this.teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(Teacher teacher){
        String encPsd = this.passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encPsd);
        Teacher teacher1 = (Teacher) this.teacherRepository.findById(teacher.getId()).orElseThrow(null);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setAge(teacher.getAge());
        teacher1.setGender(teacher.getGender());
        teacher1.setService_type(teacher.getService_type());
        teacher1.setAddress(teacher.getAddress());
        teacher1.setPhoneNumber(teacher.getPhoneNumber());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setRoles(teacher.getRoles());
        teacher1.setEducation_level(teacher.getEducation_level());

        return this.teacherRepository.save(teacher1);
    }
}
