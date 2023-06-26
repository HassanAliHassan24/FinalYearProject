package com.application.ScienceTeacher.Repository;

import com.application.ScienceTeacher.Entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
