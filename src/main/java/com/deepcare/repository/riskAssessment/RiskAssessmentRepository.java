package com.deepcare.repository.riskAssessment;

import com.deepcare.domain.riskAssessment.RiskAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiskAssessmentRepository extends JpaRepository<RiskAssessment, String> {
    // 회기 1건당 위험요인 평가 1건 (OneToOne)
    Optional<RiskAssessment> findBySession_Id(String sessionId);
}