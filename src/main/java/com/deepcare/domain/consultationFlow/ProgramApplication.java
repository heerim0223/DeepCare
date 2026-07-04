package com.deepcare.domain.consultationFlow;

import com.deepcare.domain.client.Client;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "program_applications")
public class ProgramApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "application_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "program_id", nullable = false)
    // TODO: Program 마스터 테이블 생기면 FK로 교체
    private String programId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private ProgramStatus status;

    @ElementCollection
    @CollectionTable(name = "program_application_docs", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "doc_name")
    private List<String> docsRequired;

    @ElementCollection
    @CollectionTable(name = "program_application_docs_submitted", joinColumns = @JoinColumn(name = "application_id"))
    @Column(name = "doc_name")
    @Builder.Default
    private List<String> docsSubmitted = new ArrayList<>();

    @CreatedDate
    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    public static ProgramApplication create(Client client, String programId, List<String> docsRequired) {
        return ProgramApplication.builder()
                .client(client)
                .programId(programId)
                .status(ProgramStatus.RECEIVED)
                .docsRequired(docsRequired == null ? new ArrayList<>() : docsRequired)
                .docsSubmitted(new ArrayList<>())
                .build();
    }

    public void changeStatus(ProgramStatus status) {
        this.status = status;
    }

    public List<String> getDocsPending() {
        if (docsRequired == null) {
            return List.of();
        }

        return docsRequired.stream()
                .filter(doc -> docsSubmitted == null || !docsSubmitted.contains(doc))
                .toList();
    }
}
