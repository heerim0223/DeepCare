package com.deepcare.repository.session;

import com.deepcare.domain.session.SessionParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionParticipantRepository extends JpaRepository<SessionParticipant, String> {
    List<SessionParticipant> findBySession_Id(String sessionId);
}
