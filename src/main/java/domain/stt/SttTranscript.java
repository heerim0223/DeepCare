package domain.stt;

import domain.session.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stt_transcripts")
public class SttTranscript {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transcript_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "provider", length = 50, nullable = true)
    private String provider;

    @Column(name = "language", length = 10, nullable = true)
    private String language;

    @Column(name = "raw_text")
    @Lob
    private String rawText;

    @Column(name = "speaker_segments_json", nullable = true)
    @Lob
    private String speakerSegmentsJson;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
