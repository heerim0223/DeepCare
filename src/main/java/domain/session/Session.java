package domain.session;

import domain.client.Client;
import domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "session_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "session_date")
    private LocalDate date;

    @Column(name = "session_time_start")
    private LocalDateTime timeStart;

    @Column(name = "session_time_end")
    private LocalDateTime timeEnd;

    @Column(name = "session_duration_min")
    private Integer durationMin;

    @Column(name = "session_method", length = 20)
    @Enumerated(EnumType.STRING)
    private Method method;

    @Column(name = "session_location", length = 100, nullable = true)
    private String location;

    @Column(name = "session_type", length = 30)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "session_number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "worker_user_id")
    private User workerUser;

    @ManyToOne
    @JoinColumn(name = "supervisor_user_id", nullable = true)
    private User supervisorUser;

    @Column(name = "status", length = 20)
    @ColumnDefault("'DRAFT'")
    private Status status;

    @Column(name = "signed_at", nullable = true)
    private LocalDateTime signedAt;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
