package com.deepcare.repository.consultationFlow;

import com.deepcare.domain.consultationFlow.CaseStage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseStageRepository extends JpaRepository<CaseStage, String> {
    List<CaseStage> findByClient_IdOrderByCreatedAtAsc(String clientId);
}
