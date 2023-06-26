package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.Policy;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.PolicyRepositotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolicyService {

    @Autowired
    public PolicyRepositotry policyRepository;
    public Policy addPolicy(Policy policy){
        return this.policyRepository.save(policy);
    }
    public List<Policy> getAllPolicy(){
        return this.policyRepository.findAll();
    }
    public Policy getById(Integer policy_id){
        return (Policy) this.policyRepository.findById(policy_id).orElseThrow(()->
                new ResourceNotFoundException("That"+policy_id+"NotFound"));

    }
    public void deletePolicyById(Integer policy_id){
        this.policyRepository.deleteById(policy_id);
    }
    public Policy updatePolicy(Policy policy){
        Policy policy1 = this.policyRepository.findById(policy.getPolicy_id()).orElseThrow(null);
        policy1.setPolicy_name(policy.getPolicy_name());
        policy1.setPolicy_description(policy.getPolicy_description());
        return this.policyRepository.save(policy1);

    }
}
