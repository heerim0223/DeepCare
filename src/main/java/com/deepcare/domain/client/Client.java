package com.deepcare.domain.client;

import com.deepcare.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_user_id")
    private User clientUser;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 20, nullable = false)
    private Gender gender;

    @Column(name = "contact_phone", length = 30, nullable = false)
    private String contactPhone;

    @Column(name = "contact_safe_time", length = 100)
    private String contactSafeTime;

    @Column(name = "address", length = 255)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", length = 50)
    private AddressType addressType;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "disability_yn", nullable = false)
    @ColumnDefault("false")
    private Boolean disabilityYn = false;

    @Column(name = "disability_type", length = 100)
    private String disabilityType;

    @ManyToOne
    @JoinColumn(name = "primary_worker_user_id", nullable = false)
    private User user;

    @Column(name = "intake_date", nullable = false)
    private LocalDate intakeDate;

    @Column(name = "referral_source", length = 100)
    private String referralSource;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
