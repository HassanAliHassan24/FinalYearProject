package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.Program;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.ProgramRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    public ProgramRespository programRepository;


    public Program addProgram(Program program){
        return this.programRepository.save(program);
    }

    public List<Program> getAllProgram(){
        return this.programRepository.findAll();
    }

    public Program getById(Integer program_id){
        return this.programRepository.findById(program_id).orElseThrow(()->
                new ResourceNotFoundException("That"+program_id+"NotFound"));
    }

    public void deleteProgramById(Integer program_id){
        this.programRepository.deleteById(program_id);
    }
    public Program updateProgram(Program program){
        Program program1 = this.programRepository.findById(program.getProgram_id()).orElseThrow(null);
        program1.setProgram_name(program.getProgram_name());
        program1.setDuration(program.getDuration());
        program1.setPrerequisite(program.getPrerequisite());
        return this.programRepository.save(program1);

    }
}
