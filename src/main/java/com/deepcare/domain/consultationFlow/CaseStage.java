package com.deepcare.domain.consultationFlow;

import com.deepcare.domain.client.Client;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "case_stages")
public class CaseStage {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "case_stage_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "stage_type", length = 30, nullable = false)
    private CaseStageType stage;

    @OneToMany(mappedBy = "caseStage", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<CaseGoal> goals = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public static CaseStage create(Client client, CaseStageType stage, List<String> goals) {
        CaseStage caseStage = CaseStage.builder()
                .client(client)
                .stage(stage)
                .goals(new ArrayList<>())
                .build();

        if (goals != null) {
            goals.forEach(caseStage::addGoal);
        }

        return caseStage;
    }

    public void addGoal(String description) {
        goals.add(CaseGoal.create(this, description));
    }

    public int getStageProgressPct() {
        return (int) Math.round((stage.ordinal() + 1) * 100.0 / CaseStageType.values().length);
    }
}
