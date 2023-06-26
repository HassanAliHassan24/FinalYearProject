//package com.application.ScienceTeacher.Service;
//
//import com.application.ScienceTeacher.Entity.Qualification;
//import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
//import com.application.ScienceTeacher.Repository.QualificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class QualificationService {
//
//    @Autowired
//    public QualificationRepository qualificationRepository;
//    public Qualification addQualification(Qualification qualification){
//        return this.qualificationRepository.save(qualification);
//    }
//    public List<Qualification> getAllQualification(){
//        return this.qualificationRepository.findAll();
//    }
//
//    public Qualification getById(Integer qualification_Id){
//        return this.qualificationRepository.findById(qualification_Id).orElseThrow(()->
//                new ResourceNotFoundException("ThatId" + qualification_Id + "NotFound"));
//    }
//
//    public void deleteQualificationById(Integer qualification_Id){
//        this.qualificationRepository.deleteById(qualification_Id);
//    }
//    public Qualification updateQualification(Qualification qualification){
//        Qualification qualification1 = this.qualificationRepository.findById(qualification.getQualification_Id()).orElseThrow(null);
//        qualification1.setCertificate_name(qualification.getCertificate_name());
//        qualification1.setCertificate_type(qualification.getCertificate_type());
//        qualification1.setCertificate_released_date(qualification.getCertificate_released_date());
//        return this.qualificationRepository.save(qualification1);
//    }
//}
