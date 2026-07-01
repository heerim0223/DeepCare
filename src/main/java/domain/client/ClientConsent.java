package domain.client;

import domain.user.User;
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
@Table(name = "client_consents")
public class ClientConsent {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "consent_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "consent_recording")
    private Boolean recording;

    @Column(name = "consent_sensitive")
    private Boolean sensitive;

    @Column(name = "consent_third_party")
    private Boolean thirdParty;

    @Column(name = "consent_camera")
    @ColumnDefault("false")
    private Boolean camera;

    @Column(name = "guardian_consent_yn")
    @ColumnDefault("false")
    private Boolean guardianConsentYn;

    @Column(name = "guardian_name", length = 200, nullable = true)
    private String guardianName;

    @Column(name = "consent_date")
    @CreatedDate
    private LocalDateTime date;

    @Column(name = "consent_withdraw_yn")
    @ColumnDefault("false")
    private Boolean withdrawYn;

    @Column(name = "consent_withdraw_date", nullable = true)
    private LocalDateTime withdrawDate;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id", nullable = true)
    private User user;
}
