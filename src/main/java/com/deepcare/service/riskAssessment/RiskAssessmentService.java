package com.deepcare.service.riskAssessment;

import com.deepcare.domain.riskAssessment.RiskAssessment;
import com.deepcare.domain.riskAssessment.RiskLevel;
import com.deepcare.domain.session.Session;
import com.deepcare.dto.riskAssessment.request.RiskAssessmentRequest;
import com.deepcare.dto.riskAssessment.response.RiskAssessmentCreateResponse;
import com.deepcare.dto.riskAssessment.response.RiskAssessmentResponse;
import com.deepcare.repository.riskAssessment.RiskAssessmentRepository;
import com.deepcare.repository.session.SessionRepository;
import com.deepcare.service.notification.NotificationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RiskAssessmentService {

    private final RiskAssessmentRepository riskAssessmentRepository;
    private final SessionRepository sessionRepository;
    private final NotificationService notificationService;

    // R-1: 위험요인 평가 조회
    public RiskAssessmentResponse getRiskAssessment(String sessionId) {
        RiskAssessment riskAssessment = riskAssessmentRepository.findBySession_Id(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("위험요인 평가를 찾을 수 없습니다."));

        return RiskAssessmentResponse.from(riskAssessment);
    }

    // R-2: 위험요인 평가 등록 (risk_level=high 시 Push 알림 자동 발송)
    public RiskAssessmentCreateResponse createRiskAssessment(String sessionId, RiskAssessmentRequest request) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("회기를 찾을 수 없습니다."));

        RiskAssessment riskAssessment = RiskAssessment.create(
                session,
                request.riskFlag(),
                request.riskType(),
                request.riskLevel(),
                request.suicideIdeation(),
                request.selfHarmYn(),
                request.abuseSuspicionYn(),
                request.dvYn(),
                request.substanceUseYn(),
                request.neglectYn(),
                request.riskActionTaken(),
                request.reportYn(),
                request.reportDate(),
                request.reportAgency()
        );

        riskAssessmentRepository.save(riskAssessment);

        boolean alertSent = false;
        if (riskAssessment.getRiskLevel() == RiskLevel.HIGH) {
            notificationService.sendRiskAlert(session, riskAssessment);
            alertSent = true;
        }

        return RiskAssessmentCreateResponse.of(riskAssessment, alertSent);
    }

    // R-3: 위험요인 평가 수정
    public RiskAssessmentResponse updateRiskAssessment(String sessionId, RiskAssessmentRequest request) {
        RiskAssessment riskAssessment = riskAssessmentRepository.findBySession_Id(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("위험요인 평가를 찾을 수 없습니다."));

        boolean wasHighRisk = riskAssessment.isHighRisk();

        riskAssessment.update(
                request.riskFlag(),
                request.riskType(),
                request.riskLevel(),
                request.suicideIdeation(),
                request.selfHarmYn(),
                request.abuseSuspicionYn(),
                request.dvYn(),
                request.substanceUseYn(),
                request.neglectYn(),
                request.riskActionTaken(),
                request.reportYn(),
                request.reportDate(),
                request.reportAgency()
        );

        // 수정으로 인해 새롭게 high 위험으로 전환된 경우에도 알림 발송
        if (!wasHighRisk && riskAssessment.isHighRisk()) {
            notificationService.sendRiskAlert(riskAssessment.getSession(), riskAssessment);
        }

        return RiskAssessmentResponse.from(riskAssessment);
    }
}
