//package com.application.ScienceTeacher.Controller;
//
//import com.application.ScienceTeacher.Entity.Qualification;
//import com.application.ScienceTeacher.Service.QualificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/Qualification")
//public class QualificationController {
//
//    @Autowired
//    public QualificationService qualificationService;
//
//
//    @PostMapping("/add")
//    public Qualification addQualification(@RequestBody Qualification qualification){
//        return this.qualificationService.addQualification(qualification);
//    }
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Qualification>> getAllQualification(){
//        List<Qualification> qualifications = this.qualificationService.getAllQualification();
//        return new ResponseEntity<>(qualifications, HttpStatus.OK);
//    }
//    @GetMapping("/getById/{qualification_Id}")
//    public  ResponseEntity<Qualification> getQualificationById(@PathVariable("qualification_Id") Integer qualification_Id){
//        Qualification qualification = this.qualificationService.getById(qualification_Id);
//        return new ResponseEntity<>(qualification, HttpStatus.OK);
//    }
//    @Transactional
//    @DeleteMapping("/deleteQualification/{qualification_Id}")
//    public void  deleteQualificationById(@PathVariable Integer qualification_Id){
//        this.qualificationService.deleteQualificationById(qualification_Id);
//    }
//    @PutMapping("/updateQualification/{qualification_Id}")
//    public Qualification updateQualification(@RequestBody Qualification qualification){
//        return this.qualificationService.updateQualification(qualification);
//    }
//
//}
