package com.deepcare.domain.camera;

import com.deepcare.domain.session.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "camera_metrics")
public class CameraMetric {
    @Id
    @Column(name = "session_id", nullable = false)
    private String sessionId;

    /*
        @ManyToOne(PK 공유 방식)에서
        @OneToOne + @MapsId 조합(최신 JPA 방식)으로 수정
    */

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(name = "consent_camera", nullable = false)
    private Boolean consentCamera;

    @Column(name = "bp_systolic_est")
    private Integer bpSystolicEst;

    @Column(name = "bp_diastolic_est")
    private Integer bpDiastolicEst;

    @Column(name = "heart_rate_est")
    private Integer heartRateEst;

    @Column(name = "stress_index_est")
    private Integer stressIndexEst;

    @Column(name = "emotion_distribution_json")
    private String emotionDistributionJson;

    @Column(name = "abnormal_flag", nullable = false)
    @ColumnDefault("false")
    private Boolean abnormalFlag = false;

    @Column(name = "abnormal_reason")
    @Lob
    private String abnormalReason;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
