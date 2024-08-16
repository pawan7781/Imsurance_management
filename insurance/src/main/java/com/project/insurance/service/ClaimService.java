package com.project.insurance.service;

import com.project.insurance.dao.ClaimDao;
import com.project.insurance.dao.InsurancePolicyDao;
import com.project.insurance.model.ApiResponse;
import com.project.insurance.model.Claim;
import com.project.insurance.model.InsurancePolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClaimService {

    @Autowired
    private InsurancePolicyDao insurancePolicyDao;
    @Autowired
    private ClaimDao claimDao;
    @Autowired
    private ApiResponse<Claim> claimResponse;
    @Autowired
    private ApiResponse<List<Claim>> findAllClaimResponse;

    public ApiResponse<Claim> insertClaim(Claim claim, int insurancePolicyId)
    {
        InsurancePolicy insurancePolicy=insurancePolicyDao.getByInsurancePolicyId(insurancePolicyId);
        if(Objects.isNull(insurancePolicy))
        {
            claimResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            claimResponse.setMsg("not claimed yet");
            claimResponse.setData(null);
        }
        else
        {
            claim.setInsurancePolicy(insurancePolicy);
            claimDao.insertClaim(claim);

            claimResponse.setStatusCode(HttpStatus.ACCEPTED.value());
            claimResponse.setMsg("claimed succesfully done");
            claimResponse.setData(claim);
        }
        return claimResponse;

    }
    public ApiResponse<Claim> getByClaimId( int claimId )
    {
        Claim claim=claimDao.getByClaimId(claimId);
        if(Objects.isNull(claim))
        {
            throw new RuntimeException("claim details not found");
        }
        claimResponse.setStatusCode(HttpStatus.ACCEPTED.value());
        claimResponse.setMsg("claim existed");
        claimResponse.setData(claim);
        return claimResponse;
    }
    public ApiResponse<Claim> deleteClaim(int claimId)
    {
        Claim claim = claimDao.deleteClaim(claimId);
        if(Objects.isNull(claim))
        {
            throw new RuntimeException("claim details not found");
        }
        claimResponse.setStatusCode(HttpStatus.FOUND.value());
        claimResponse.setMsg("claim deleted succesfully");
        claimResponse.setData(claim);
        return claimResponse;
    }
    public ApiResponse<Claim> updateClaim(Claim claim)
    {
        Claim updateClaim = claimDao.updateClaim(claim);
        if(Objects.isNull(updateClaim))
        {
            throw new RuntimeException("claim details not found");
        }
        updateClaim.setClaimNumber(claim.getClaimNumber());
        updateClaim.setClaimDate(claim.getClaimDate());
        updateClaim.setClaimStatus(claim.getClaimStatus());
        updateClaim.setClaimDescription(claim.getClaimDescription());

        claimResponse.setStatusCode(HttpStatus.FOUND.value());
        claimResponse.setMsg("claim updated succesfully");
        claimResponse.setData(updateClaim);
        return claimResponse;
    }
    public ApiResponse<List<Claim>> displayAllClaims() {
        List<Claim> claims = claimDao.displayAllClaims();
        if (Objects.isNull(claims)) {
            findAllClaimResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            findAllClaimResponse.setMsg("claims details are not found");
            findAllClaimResponse.setData(null);
        } else {
            findAllClaimResponse.setStatusCode(HttpStatus.FOUND.value());
            findAllClaimResponse.setMsg("claims details found");
            findAllClaimResponse.setData(claims);
        }
        return findAllClaimResponse;
    }

}
