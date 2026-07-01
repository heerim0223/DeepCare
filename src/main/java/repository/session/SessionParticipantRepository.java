package repository.session;

import domain.session.SessionParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionParticipantRepository extends JpaRepository<SessionParticipant, String> {
    List<SessionParticipant> findBySession_Id(String sessionId);
}
