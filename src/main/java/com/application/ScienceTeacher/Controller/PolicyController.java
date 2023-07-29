package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Policy;
import com.application.ScienceTeacher.Repository.PolicyRepositotry;
import com.application.ScienceTeacher.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/Policy")
public class PolicyController {

    @Autowired
    public PolicyService policyService;

    @Autowired
    public PolicyRepositotry policyRepository;


    @PostMapping("/add")
    public Policy addPolicy(@RequestBody Policy policy){
        return this.policyService.addPolicy(policy);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Policy>> getAllPolicy(){
        List<Policy> policies = this.policyService.getAllPolicy();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Policy> getPolicyByI(@PathVariable("id")Integer id){
        Policy policy = this.policyService.getById(id);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/deletePolicy/{id}")
    public void deletePolicyById(@PathVariable Integer id){
        this.policyService.deletePolicyById(id);
    }
    @PutMapping("/updatePolicy/{id}")
    public Policy updatePolicy(@RequestBody Policy policy){
        return this.policyService.updatePolicy(policy);
    }

}
