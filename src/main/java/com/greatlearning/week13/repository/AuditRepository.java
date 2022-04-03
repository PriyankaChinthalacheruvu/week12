package com.greatlearning.week13.repository;

import com.greatlearning.week13.pojo.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog,Integer> {
}
