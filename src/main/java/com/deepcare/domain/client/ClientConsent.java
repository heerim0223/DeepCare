package com.deepcare.domain.client;

import com.deepcare.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "client_consents")
public class ClientConsent {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "consent_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "consent_recording", nullable = false)
    private Boolean recording;

    @Column(name = "consent_sensitive", nullable = false)
    private Boolean sensitive;

    @Column(name = "consent_third_party", nullable = false)
    private Boolean thirdParty;

    @Column(name = "consent_camera", nullable = false)
    @ColumnDefault("false")
    private Boolean camera = false;

    @Column(name = "guardian_consent_yn", nullable = false)
    @ColumnDefault("false")
    private Boolean guardianConsentYn = false;

    @Column(name = "guardian_name", length = 200)
    private String guardianName;

    @Column(name = "consent_date", nullable = false)
    @CreatedDate
    private LocalDateTime date;

    @Column(name = "consent_withdraw_yn", nullable = false)
    @ColumnDefault("false")
    private Boolean withdrawYn = false;

    @Column(name = "consent_withdraw_date")
    private LocalDateTime withdrawDate;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private User user;
}
