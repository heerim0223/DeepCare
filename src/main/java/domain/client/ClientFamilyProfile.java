package domain.client;

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
@Table(name = "client_family_profile")
public class ClientFamilyProfile {
    @Id
    @Column(name = "client_id", nullable = false)
    private String clientId;

    /*
        @ManyToOne(PK 공유 방식)에서
        @OneToOne + @MapsId 조합(최신 JPA 방식)으로 수정
    */

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "household_type", length = 50)
    private String householdType;

    @Column(name = "household_count")
    private Integer householdCount;

    @Column(name = "key_supporter", length = 200)
    private String keySupporter;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_support_level", length = 10)
    private SocialSupportLevel socialSupportLevel;

    @Column(name = "family_conflict_yn", nullable = false)
    @ColumnDefault("false")
    private Boolean familyConflictYn = false;

    @Column(name = "family_violence_yn", nullable = false)
    @ColumnDefault("false")
    private Boolean familyViolenceYn = false;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
