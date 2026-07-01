package com.deepcare.domain.visibility;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.user.User;
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
@Table(name = "field_visibility")
public class FieldVisibility {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "visibility_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "field_key", length = 100, nullable = false)
    private String fieldKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "visibility", length = 20, nullable = false)
    private Visibility visibility;

    @Column(name = "is_visible_to_client", nullable = false)
    @ColumnDefault("false")
    private Boolean isVisibleToClient = false;

    @ManyToOne
    @JoinColumn(name = "set_by_user_id", nullable = false)
    private User user;

    @Column(name = "set_at", nullable = false)
    @CreatedDate
    private LocalDateTime setAt;
}
