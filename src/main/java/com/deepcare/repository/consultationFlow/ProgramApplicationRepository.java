package com.deepcare.repository.consultationFlow;

import com.deepcare.domain.consultationFlow.ProgramApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgramApplicationRepository extends JpaRepository<ProgramApplication, String> {
    List<ProgramApplication> findByClient_Id(String clientId);

    Optional<ProgramApplication> findByIdAndClient_Id(String id, String clientId);
}
