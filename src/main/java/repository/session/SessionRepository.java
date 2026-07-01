package repository.session;

import domain.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, String> {
    // 클라이언트 상세 화면(회기 이력)
    List<Session> findByClient_IdOrderByDateDesc(String clientId);
}
