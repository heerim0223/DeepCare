package com.deepcare.repository.riskAssessment;

import com.deepcare.domain.riskAssessment.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, String> {
}