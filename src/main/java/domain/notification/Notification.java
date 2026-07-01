package domain.notification;

import domain.session.Session;
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
@Table(name = "notifications")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "notification_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "recipient_user_id")
    private User user;

    @Column(name = "type", length = 50)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "body", nullable = true)
    @Lob
    private String body;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "is_read")
    @ColumnDefault("false")
    private Boolean isRead;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "read_at")
    private LocalDateTime readAt;
}
