package com.project.insurance.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.project.insurance.service.InsurancePolicyService.getByInsurancePolicyId(..))&& args(insurancePolicyId)")
    public Object ValidateinsurancePolicyId(ProceedingJoinPoint jp, int insurancePolicyId) throws Throwable {
        if (insurancePolicyId < 0) {
            LOGGER.info("negative postId: updating");
            insurancePolicyId = -insurancePolicyId;
            LOGGER.info("new value: " + insurancePolicyId);
        }
        Object res = jp.proceed(new Object[]{insurancePolicyId});
        return res;
    }
    @Around("execution(* com.project.insurance.service.ClientService.getByClientId(..))&& args(clientId)")
    public Object ValidateclientId(ProceedingJoinPoint jp, int clientId) throws Throwable {
        if (clientId < 0) {
            LOGGER.info("negative clientId: updating");
            clientId = -clientId;
            LOGGER.info("new value: " + clientId);
        }
        Object res = jp.proceed(new Object[]{clientId});
        return res;
    }
    @Around("execution(* com.project.insurance.service.ClaimService.getByClaimId(..))&& args(claimId)")
    public Object ValidateclaimId(ProceedingJoinPoint jp, int claimId) throws Throwable {
        if (claimId < 0) {
            LOGGER.info("negative claimId: updating");
            claimId = -claimId;
            LOGGER.info("new value: " + claimId);
        }
        Object res = jp.proceed(new Object[]{claimId});
        return res;
    }
}