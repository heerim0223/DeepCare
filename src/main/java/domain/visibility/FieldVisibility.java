package domain.visibility;

import domain.client.Client;
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
@Table(name = "field_visibility")
public class FieldVisibility {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "visibility_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "field_key", length = 100)
    private String fieldKey;

    @Column(name = "visibility", length = 20)
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @Column(name = "is_visible_to_client")
    @ColumnDefault("false")
    private Boolean isVisibleToClient;

    // Column ID: set_by_user_id
    @ManyToOne
    @JoinColumn(name = "set_by_user_id")
    private User user;

    @Column(name = "set_at")
    @CreatedDate
    private LocalDateTime setAt;
}
