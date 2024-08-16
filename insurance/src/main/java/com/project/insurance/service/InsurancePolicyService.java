package com.project.insurance.service;

import com.project.insurance.dao.InsurancePolicyDao;
import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.Client;
import com.project.insurance.model.InsurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyDao insurancePolicyDao;
    @Autowired
    private ApiResponse<InsurancePolicy> insurancePolicyResponse;
    @Autowired
    private ApiResponse<List<InsurancePolicy>> findAllInsurancePolicyResponse;

    public ApiResponse<InsurancePolicy> insertInsurancePolicy( InsurancePolicy insurancePolicy ) {
        insurancePolicy= insurancePolicyDao.insertInsurancePolicy(insurancePolicy);
       if(Objects.isNull(insurancePolicy))
       {
           insurancePolicyResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
           insurancePolicyResponse.setMsg("Insurance Policy id not found");
           insurancePolicyResponse.setData(null);
       }
        insurancePolicyResponse.setStatusCode(HttpStatus.ACCEPTED.value());
        insurancePolicyResponse.setMsg("Insurance Policy id found");
        insurancePolicyResponse.setData(insurancePolicy);
        return insurancePolicyResponse;
    }
    public ApiResponse<InsurancePolicy> getByInsurancePolicyId(int insurancePolicyId)
    {
        InsurancePolicy insurancePolicy=insurancePolicyDao.getByInsurancePolicyId(insurancePolicyId);
        if(Objects.isNull(insurancePolicy))
        {
            throw new RuntimeException("insurance details not found");
        }
        insurancePolicyResponse.setStatusCode(HttpStatus.ACCEPTED.value());
        insurancePolicyResponse.setMsg("insurance policy details found");
        insurancePolicyResponse.setData(insurancePolicy);

        return insurancePolicyResponse;

    }
    public ApiResponse<InsurancePolicy> deleteInsurancePolicy(int insurancePolicyId)
    {
        InsurancePolicy insurancePolicy=insurancePolicyDao.deleteInsurancePolicy(insurancePolicyId);
        if(Objects.isNull(insurancePolicy))
        {
            throw new RuntimeException("insurance details not found");
        }
        insurancePolicyResponse.setStatusCode(HttpStatus.FOUND.value());
        insurancePolicyResponse.setMsg("insurance policy deleted successfully");
        insurancePolicyResponse.setData(insurancePolicy);

        return insurancePolicyResponse;

    }
    public ApiResponse<List<InsurancePolicy>>displayAllInsurancePolicy()
    {
        List<InsurancePolicy> policy=insurancePolicyDao.displayAllInsurancePolicy();
        if(Objects.isNull(policy))
        {
            findAllInsurancePolicyResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            findAllInsurancePolicyResponse.setMsg("Data not found");
            findAllInsurancePolicyResponse.setData(null);


        }
        findAllInsurancePolicyResponse.setStatusCode(HttpStatus.FOUND.value());
        findAllInsurancePolicyResponse.setMsg("Data displayed");
        findAllInsurancePolicyResponse.setData(policy);


        return findAllInsurancePolicyResponse;

    }



}
