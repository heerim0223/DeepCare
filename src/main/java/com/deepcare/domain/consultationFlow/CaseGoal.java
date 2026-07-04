package com.deepcare.domain.consultationFlow;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "case_goals")
public class CaseGoal {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "case_goal_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "case_stage_id", nullable = false)
    private CaseStage caseStage;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "achieved", nullable = false)
    @ColumnDefault("false")
    @Builder.Default
    private Boolean achieved = false;

    public static CaseGoal create(CaseStage caseStage, String description) {
        return CaseGoal.builder()
                .caseStage(caseStage)
                .description(description)
                .achieved(false)
                .build();
    }
}
