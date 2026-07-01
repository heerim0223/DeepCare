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
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private String id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_user_id", nullable = true)
    private String userId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "gender")
    @Enumerated
    private Gender gender;

    @Column(name = "contact_phone", length = 30)
    private String contactPhone;

    @Column(name = "contact_safe_time", length = 100, nullable = true)
    private String contactSafeTime;

    @Column(name = "address", length = 255, nullable = true)
    private String address;

    @Column(name = "address_type", length = 50, nullable = true)
    private AddressType addressType;

    @Column(name = "nationality", length = 50, nullable = true)
    private String nationality;

    @Column(name = "disability_yn")
    @ColumnDefault("false")
    private Boolean disabilityYn;

    @Column(name = "disability_type", length = 100, nullable = true)
    private String disabilityType;

    @ManyToOne
    @JoinColumn(name = "primary_worker_user_id")
    private User user;

    @Column(name = "intake_date")
    private LocalDateTime intakeDate;

    @Column(name = "referral_source", length = 100, nullable = true)
    private String referralSource;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @CreatedDate
    private LocalDateTime updatedAt;
}
