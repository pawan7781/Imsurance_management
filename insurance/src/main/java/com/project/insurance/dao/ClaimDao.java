package com.project.insurance.dao;

import com.project.insurance.model.Claim;
import com.project.insurance.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClaimDao {
    @Autowired
    private ClaimRepository claimRepository;

    public Claim insertClaim(Claim claim)
    {
        return claimRepository.save(claim);
    }

    public Claim getByClaimId(int claimId)
    {
        Optional<Claim>optional = claimRepository.findById(claimId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }
    public Claim deleteClaim(int claimId)
    {
        Optional<Claim>optional = claimRepository.findById(claimId);
        if(optional.isPresent())
        {
            claimRepository.deleteById(claimId);
            return optional.get();

        }
        return null;
    }
    public Claim updateClaim(Claim claim)
    {
        return claimRepository.save(claim);
    }
    public List<Claim> displayAllClaims()
    {
       return claimRepository.findAll();
    }

}
