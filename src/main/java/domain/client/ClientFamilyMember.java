package domain.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_family_members")
public class ClientFamilyMember {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "family_member_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "name", length = 100, nullable = true)
    private String name;

    @Column(name = "relation", length = 50, nullable = true)
    private String relation;

    @Column(name = "age", nullable = true)
    private Integer age;

    @Column(name = "cohabitation_status", length = 30, nullable = true)
    @Enumerated
    private CohabitationStatus cohabitationStatus;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
