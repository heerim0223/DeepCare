package domain.session;

import domain.client.ClientFamilyMember;
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
@Table(name = "session_participants")
public class SessionParticipant {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "session_participant_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

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
}
