package com.deepcare.repository.consultationFlow;

import com.deepcare.domain.consultationFlow.CrisisProtocol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrisisProtocolRepository extends JpaRepository<CrisisProtocol, String> {
    Optional<CrisisProtocol> findBySession_Id(String sessionId);
}
