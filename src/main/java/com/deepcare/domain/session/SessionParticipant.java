package com.deepcare.domain.session;

import com.deepcare.domain.client.ClientFamilyMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "session_participants")
public class SessionParticipant {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "session_participant_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Enumerated(EnumType.STRING)
    @Column(name = "participant_type", length = 30, nullable = false)
    private ParticipantType participantType;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "related_family_member_id")
    private ClientFamilyMember clientFamilyMember;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    // ====

    @Column(name = "speaker_index")
    // TODO: STT 화자분리 라벨(0, 1, 2)과 매핑
    private Integer speakerIndex;

    public void changeSpeakerIndex(Integer speakerIndex) {
        this.speakerIndex = speakerIndex;
    }
}
