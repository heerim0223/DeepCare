package com.deepcare.service.notification;

import com.deepcare.domain.notification.Notification;
import com.deepcare.domain.notification.Type;
import com.deepcare.domain.consultationFlow.CrisisProtocol;
import com.deepcare.domain.riskAssessment.RiskAssessment;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.user.User;
import com.deepcare.domain.user.UserType;
import com.deepcare.repository.notification.NotificationRepository;
import com.deepcare.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    // NT-4: 위험 신호 Push 발송 — 슈퍼바이저·관리자 자동 수신
    // R-2: risk_level=high 등록 시 자동 호출
    public List<Notification> sendRiskAlert(Session session, RiskAssessment riskAssessment) {
        Set<User> recipients = new LinkedHashSet<>();

        if (session.getSupervisorUser() != null) {
            recipients.add(session.getSupervisorUser());
        }
        // TODO: 기관(organization) 단위 스코핑 — 현재는 전체 슈퍼바이저·관리자 대상 발송
        recipients.addAll(userRepository.findByUserTypeIn(List.of(UserType.SUPERVISOR, UserType.ORG_ADMIN)));

        String title = "[위험 신호] " + session.getClient().getName() + " 클라이언트";
        String body = "위험 수준: " + riskAssessment.getRiskLevel()
                + " / 회기: " + session.getId()
                + " - 즉시 확인이 필요합니다.";

        return recipients.stream()
                .map(recipient -> notify(recipient, Type.RISK, title, body, session))
                .toList();
    }

    public Notification notify(User recipient, Type type, String title, String body, Session session) {
        Notification notification = new Notification(
                null,
                recipient,
                type,
                title,
                body,
                session,
                false,
                LocalDateTime.now(),
                null
        );

        return notificationRepository.save(notification);
    }

    public List<Notification> sendCrisisProtocolAlert(Session session, CrisisProtocol crisisProtocol) {
        Set<User> recipients = new LinkedHashSet<>();

        if (session.getSupervisorUser() != null) {
            recipients.add(session.getSupervisorUser());
        }
        recipients.addAll(userRepository.findByUserTypeIn(List.of(UserType.SUPERVISOR, UserType.ORG_ADMIN)));

        String title = "[위기개입] " + session.getClient().getName() + " 클라이언트";
        String body = "위기 유형: " + crisisProtocol.getCrisisType()
                + " / 회기: " + session.getId()
                + " - 위기조치 체크리스트 확인이 필요합니다.";

        return recipients.stream()
                .map(recipient -> notify(recipient, Type.RISK, title, body, session))
                .toList();
    }
}
