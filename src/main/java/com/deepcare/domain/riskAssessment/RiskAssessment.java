package com.deepcare.domain.riskAssessment;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.session.Session;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "risk_assessments")
public class RiskAssessment {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "risk_assessment_id", nullable = false)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(name = "risk_flag", nullable = false)
    private Boolean riskFlag;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "risk_types",
            joinColumns = @JoinColumn(name = "risk_assessment_id")
    )
    @Column(name = "risk_type", length = 30)
    private List<RiskType> riskTypes;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_level", length = 20)
    private RiskLevel riskLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "suicide_ideation", length = 20)
    private SuicideIdeation suicideIdeation;

    @Column(name = "self_harm_yn")
    private Boolean selfHarmYn;

    @Column(name = "abuse_suspicion_yn")
    private Boolean abuseSuspicionYn;

    @Column(name = "dv_yn")
    private Boolean dvYn;

    @Column(name = "substance_use_yn")
    private Boolean substanceUseYn;

    @Column(name = "neglect_yn")
    private Boolean neglectYn;

    @Column(name = "risk_action_taken", length = 1000)
    private String riskActionTaken;

    @Column(name = "report_yn")
    private Boolean reportYn;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "report_agency", length = 100)
    private String reportAgency;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public static RiskAssessment create(
            Session session,
            Boolean riskFlag,
            List<RiskType> riskTypes,
            RiskLevel riskLevel,
            SuicideIdeation suicideIdeation,
            Boolean selfHarmYn,
            Boolean abuseSuspicionYn,
            Boolean dvYn,
            Boolean substanceUseYn,
            Boolean neglectYn,
            String riskActionTaken,
            Boolean reportYn,
            LocalDate reportDate,
            String reportAgency
    ) {
        return RiskAssessment.builder()
                .session(session)
                .riskFlag(riskFlag)
                .riskTypes(riskTypes)
                .riskLevel(riskLevel)
                .suicideIdeation(suicideIdeation)
                .selfHarmYn(selfHarmYn)
                .abuseSuspicionYn(abuseSuspicionYn)
                .dvYn(dvYn)
                .substanceUseYn(substanceUseYn)
                .neglectYn(neglectYn)
                .riskActionTaken(riskActionTaken)
                .reportYn(reportYn)
                .reportDate(reportDate)
                .reportAgency(reportAgency)
                .build();
    }

    public void update(
            Boolean riskFlag,
            List<RiskType> riskTypes,
            RiskLevel riskLevel,
            SuicideIdeation suicideIdeation,
            Boolean selfHarmYn,
            Boolean abuseSuspicionYn,
            Boolean dvYn,
            Boolean substanceUseYn,
            Boolean neglectYn,
            String riskActionTaken,
            Boolean reportYn,
            LocalDate reportDate,
            String reportAgency
    ) {
        this.riskFlag = riskFlag;
        this.riskTypes = riskTypes;
        this.riskLevel = riskLevel;
        this.suicideIdeation = suicideIdeation;
        this.selfHarmYn = selfHarmYn;
        this.abuseSuspicionYn = abuseSuspicionYn;
        this.dvYn = dvYn;
        this.substanceUseYn = substanceUseYn;
        this.neglectYn = neglectYn;
        this.riskActionTaken = riskActionTaken;
        this.reportYn = reportYn;
        this.reportDate = reportDate;
        this.reportAgency = reportAgency;
    }

    public boolean isHighRisk() {
        return this.riskLevel == RiskLevel.HIGH;
    }
}