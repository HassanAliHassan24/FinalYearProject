package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Program;
import com.application.ScienceTeacher.Repository.ProgramRespository;
import com.application.ScienceTeacher.Repository.TeacherRepository;
import com.application.ScienceTeacher.Service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Program")
public class ProgramController {

    @Autowired
    public ProgramService programService;
    @Autowired
    public ProgramRespository programRepository;

    @PostMapping("/add")
    public Program addProgram(@RequestBody Program program){
        return this.programService.addProgram(program);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Program>> getAllProgram(){
        List<Program> programs = this.programService.getAllProgram();
        return new ResponseEntity<>(programs, HttpStatus.OK);

    }
    @GetMapping("/getById/{program_id}")
    public ResponseEntity<Program> getProgramById(@PathVariable("program_id") Integer program_id){
        Program program = this.programService.getById(program_id);
        return new ResponseEntity<>(program, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/deleteProgram/{program_id}")
    public  void deleteProgramById(@PathVariable Integer program_id){
        this.programService.deleteProgramById(program_id);
    }
    @PutMapping("/updateProgram/{program_id}")
    public Program updateProgram(@RequestBody Program program){
        return this.programService.updateProgram(program);
    }

}
