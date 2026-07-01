package com.deepcare.domain.session;

import com.deepcare.domain.client.Client;
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
@Table(name = "sessions")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "session_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "session_date", nullable = false)
    private LocalDate date;

    @Column(name = "session_time_start", nullable = false)
    private LocalDateTime timeStart;

    @Column(name = "session_time_end", nullable = false)
    private LocalDateTime timeEnd;

    @Column(name = "session_duration_min", nullable = false)
    private Integer durationMin;

    @Enumerated(EnumType.STRING)
    @Column(name = "session_method", length = 20, nullable = false)
    private Method method;

    @Column(name = "session_location", length = 100, nullable = true)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "session_type", length = 30, nullable = false)
    private Type type;

    @Column(name = "session_number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "worker_user_id", nullable = false)
    private User workerUser;

    @ManyToOne
    @JoinColumn(name = "supervisor_user_id")
    private User supervisorUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    @ColumnDefault("'DRAFT'")
    private Status status = Status.DRAFT;

    @Column(name = "signed_at")
    private LocalDateTime signedAt;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
