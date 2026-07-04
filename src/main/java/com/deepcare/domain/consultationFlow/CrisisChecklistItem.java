package com.deepcare.domain.consultationFlow;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "crisis_checklist_items")
public class CrisisChecklistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "checklist_item_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "crisis_protocol_id", nullable = false)
    private CrisisProtocol crisisProtocol;

    @Column(name = "label", length = 100, nullable = false)
    private String label; // "안전 확인" 등

    @Column(name = "required", nullable = false)
    private Boolean required;

    @Column(name = "done", nullable = false)
    @ColumnDefault("false")
    @Builder.Default
    private Boolean done = false;

    @Column(name = "done_at")
    private LocalDateTime doneAt;

    public static CrisisChecklistItem create(CrisisProtocol crisisProtocol, String label, Boolean required) {
        return CrisisChecklistItem.builder()
                .crisisProtocol(crisisProtocol)
                .label(label)
                .required(required == null || required)
                .done(false)
                .build();
    }

    public void changeDone(Boolean done) {
        this.done = done != null && done;
        this.doneAt = this.done ? LocalDateTime.now() : null;
    }
}
