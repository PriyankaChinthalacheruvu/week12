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



}
