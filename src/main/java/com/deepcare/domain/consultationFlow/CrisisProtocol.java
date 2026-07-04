package com.deepcare.domain.consultationFlow;

import com.deepcare.domain.session.Session;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "crisis_protocols")
public class CrisisProtocol {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "crisis_protocol_id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Enumerated(EnumType.STRING)
    @Column(name = "crisis_type", length = 30, nullable = false)
    private CrisisType crisisType; // SUICIDE_SELF_HARM, DOMESTIC_VIOLENCE, CHILD_ABUSE, ECONOMIC, OTHER

    @Column(name = "notify_supervisor", nullable = false)
    @ColumnDefault("true")
    @Builder.Default
    private Boolean notifySupervisor = true;

    @OneToMany(mappedBy = "crisisProtocol", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CrisisChecklistItem> checklistItems = new ArrayList<>();

    @CreatedDate
    @Column(name = "activated_at")
    private LocalDateTime activatedAt;

    public static CrisisProtocol create(Session session, CrisisType crisisType, Boolean notifySupervisor) {
        CrisisProtocol crisisProtocol = CrisisProtocol.builder()
                .session(session)
                .crisisType(crisisType)
                .notifySupervisor(notifySupervisor == null || notifySupervisor)
                .checklistItems(new ArrayList<>())
                .build();

        crisisProtocol.addChecklistItem("안전 확인", true);
        crisisProtocol.addChecklistItem("긴급 연락처 확인", true);
        crisisProtocol.addChecklistItem("관련 기관 연계 여부 확인", true);

        return crisisProtocol;
    }

    public void addChecklistItem(String label, Boolean required) {
        checklistItems.add(CrisisChecklistItem.create(this, label, required));
    }
}
