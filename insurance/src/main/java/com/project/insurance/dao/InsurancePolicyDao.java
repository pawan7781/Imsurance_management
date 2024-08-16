package com.project.insurance.dao;


import com.project.insurance.model.InsurancePolicy;
import com.project.insurance.repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InsurancePolicyDao {
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy)
    {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy getByInsurancePolicyId(int insurancePolicyId)
    {
        Optional<InsurancePolicy>optional = insurancePolicyRepository.findById(insurancePolicyId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }
    public InsurancePolicy deleteInsurancePolicy(int insurancePolicyId)
    {
        Optional<InsurancePolicy>optional = insurancePolicyRepository.findById(insurancePolicyId);
        if(optional.isPresent())
        {
            insurancePolicyRepository.deleteById(insurancePolicyId);
            return optional.get();

        }
        return null;
    }
   
    public List<InsurancePolicy> displayAllInsurancePolicy()
    {
       return insurancePolicyRepository.findAll();
    }

}
