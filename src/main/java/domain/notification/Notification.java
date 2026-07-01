package domain.notification;

import domain.session.Session;
import domain.user.User;
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
@Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "notification_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "recipient_user_id", nullable = false)
    private User user;

    @Column(name = "type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "body")
    @Lob
    private String body;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "is_read", nullable = false)
    @ColumnDefault("false")
    private Boolean isRead = false;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "read_at")
    private LocalDateTime readAt;
}
