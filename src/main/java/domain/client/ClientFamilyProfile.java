package domain.client;

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
@Table(name = "client_family_profile")
public class ClientFamilyProfile {
    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "household_type", length = 50, nullable = true)
    private String householdType;

    @Column(name = "house_hold_count", nullable = true)
    private Integer householdCount;

    @Column(name = "key_supporter", length = 200, nullable = true)
    private String keySupporter;

    @Column(name = "social_support_level", length = 10, nullable = true)
    private String socialSupportLevel;

    @Column(name = "family_conflict_yn")
    @ColumnDefault("false")
    private Boolean familyConflictYn;

    @Column(name = "family_violence_yn")
    @ColumnDefault("false")
    private Boolean familyViolenceYn;

    @Column(name = "updated_at")
    @CreatedDate
    private LocalDateTime updatedAt;
}
