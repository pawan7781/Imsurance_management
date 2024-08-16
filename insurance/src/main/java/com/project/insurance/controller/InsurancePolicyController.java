package com.project.insurance.controller;

import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.InsurancePolicy;
import com.project.insurance.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyService insurancePolicyService;

    @PostMapping("/saveInsurancePolicy")
    public ApiResponse<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
        return insurancePolicyService.insertInsurancePolicy(insurancePolicy);
    }

    @GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
    public ApiResponse<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId) {
        return insurancePolicyService.getByInsurancePolicyId(insurancePolicyId);
    }

    @DeleteMapping("/deleteInsurancePolicy/{insurancePolicyId}")
    public ApiResponse<InsurancePolicy> deleteInsurancePolicy(@PathVariable int insurancePolicyId) {
        return insurancePolicyService.deleteInsurancePolicy(insurancePolicyId);
    }

    @GetMapping("/displayAllPolicy")
    public ApiResponse<List<InsurancePolicy>> displayAllPolicy() {
        return insurancePolicyService.displayAllInsurancePolicy();
    }
}
