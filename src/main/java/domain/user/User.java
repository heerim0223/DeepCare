package domain.user;

import domain.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password_hash", length = 255)
    private String passwordHash;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "phone", length = 30, nullable = true)
    private String phone;

    @Column(name = "user_type", length = 30)
    @Enumerated
    private UserType userType;

    @Column(name = "status", length = 20)
    @ColumnDefault("'ACTIVE'")
    @Enumerated
    private Status status;

    @Column(name = "last_login_at", nullable = true)
    private LocalDateTime lastLoginAt;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @CreatedDate
    private LocalDateTime updatedAt;

    // ====
    @Transient
    @OneToMany(targetEntity = Client.class, mappedBy = "user")
    private List<Client> clients = new ArrayList<>();
}
