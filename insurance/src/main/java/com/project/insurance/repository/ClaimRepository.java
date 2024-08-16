package com.project.insurance.repository;

import com.project.insurance.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends JpaRepository <Claim, Integer>{
}
