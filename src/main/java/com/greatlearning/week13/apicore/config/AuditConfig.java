package com.greatlearning.week13.apicore.config;

import com.greatlearning.week13.repository.AuditRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class AuditConfig {

    private AuditRepository repo;

//    @After("execution(public * com.greatlearning.week9.kafka.MessageController.*(..))")
//    public void logBeforeExecutingControllerPublicMethods(JoinPoint joinPoint) {
//        log.info("Triggered : {}", joinPoint.getSignature().getName());
//        AuditLog audit=new AuditLog(joinPoint.getSignature().getName());
//        //enable to save into audit table
//        //repo.save(audit);
//    }


}
