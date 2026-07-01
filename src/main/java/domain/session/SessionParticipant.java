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
    @Column(name = "session_participant_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "participant_type", length = 30)
    private ParticipantType participantType;

    @Column(name = "name", length = 100, nullable = true)
    private String name;

    // Column ID: related_family_member_id
    @ManyToOne
    @JoinColumn(name = "family_member_id", nullable = true)
    private ClientFamilyMember clientFamilyMember;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
