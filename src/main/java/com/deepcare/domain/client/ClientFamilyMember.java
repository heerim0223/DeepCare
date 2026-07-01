package com.deepcare.domain.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "client_family_members")
public class ClientFamilyMember {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "family_member_id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "relation", length = 50)
    private String relation;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "cohabitation_status", length = 30)
    private CohabitationStatus cohabitationStatus;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
