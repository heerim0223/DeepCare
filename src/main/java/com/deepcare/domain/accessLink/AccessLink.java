package com.deepcare.domain.accessLink;

import com.deepcare.domain.client.Client;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "access_links")
public class AccessLink {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "access_link_id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public void join() {
        this.status = Status.JOINED;
    }

    public void expire() {
        this.status = Status.EXPIRED;
    }

    public static AccessLink create(Client client, String token, LocalDateTime expiresAt) {
        return AccessLink.builder()
                .client(client)
                .status(Status.PENDING)
                .expiresAt(expiresAt)
                .build();
    }

    public boolean isExpired() {
        return expiresAt.isBefore(LocalDateTime.now());
    }
}