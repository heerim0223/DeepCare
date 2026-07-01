package com.deepcare.domain.stt;

import com.deepcare.domain.session.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "stt_transcripts")
public class SttTranscript {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transcript_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(name = "provider", length = 50)
    private String provider;

    @Column(name = "language", length = 10)
    @ColumnDefault("'ko'")
    private String language = "ko";

    @Lob
    @Column(name = "raw_text", nullable = false)
    private String rawText;

    @Lob
    @Column(name = "speaker_segments_json")
    private String speakerSegmentsJson;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
