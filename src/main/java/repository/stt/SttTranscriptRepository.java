package repository.stt;

import domain.stt.SttTranscript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SttTranscriptRepository extends JpaRepository<SttTranscript, String> {
}
