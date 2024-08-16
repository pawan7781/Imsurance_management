package com.project.insurance.controller;

import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.Claim;
import com.project.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @PostMapping("saveClaim/{insurancePolicyId}")
    public ApiResponse<Claim> saveClaim(@RequestBody Claim claim, @PathVariable int insurancePolicyId) {
       return claimService.insertClaim(claim, insurancePolicyId);
    }
    @GetMapping("getByClaimId/{claimId}")
    public ApiResponse<Claim> getByClaimId(@PathVariable int claimId) {
        return claimService.getByClaimId(claimId);
    }
    @DeleteMapping("deleteClaim/{claimId}")
    public ApiResponse<Claim> deleteClaim(@PathVariable int claimId) {
        return claimService.deleteClaim(claimId);
    }
    @PutMapping("updateClaim/{claimId}")
    public ApiResponse<Claim> update(@RequestBody Claim claim)  {
        return claimService.updateClaim(claim);
    }
    @GetMapping("/displayAllClaims")
    public ApiResponse<List<Claim>> displayAllClaims() {
        return claimService.displayAllClaims();
    }
}
