package domain.camera;

import domain.session.Session;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "camera_metrics")
public class CameraMetric {
    @Id
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "consent_camera")
    private Boolean consentCamera;

    @Column(name = "bp_systolic_est", nullable = true)
    private Integer bpSystolicEst;

    @Column(name = "bp_diastolic_est", nullable = true)
    private Integer bpDiastolicEst;

    @Column(name = "heart_rate_est", nullable = true)
    private Integer heartRateEst;

    @Column(name = "stress_index_est", nullable = true)
    private Integer stressIndexEst;

    @Column(name = "emotion_destribution_json", nullable = true)
    private String emotionDistributionJson;

    @Column(name = "abnormal_flag")
    @ColumnDefault("false")
    private Boolean abnormalFlag;

    @Column(name = "abnormal_reason", nullable = true)
    @Lob
    private String abnormalReason;

    @Column(name = "updated_at")
    @CreatedDate
    private LocalDateTime updatedAt;
}
