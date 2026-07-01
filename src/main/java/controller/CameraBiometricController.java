package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 카메라 / 생체 데이터
@RestController
public class CameraBiometricController {

    // BIO-1: 카메라 분석 세션 시작
    @PostMapping("/sessions/{session_id}/camera/start")
    public String startCameraSession(@PathVariable("session_id") String sessionId) {
        // TODO: consent_camera=Y 선행 필수
        return "";
    }

    // BIO-2: 카메라 분석 세션 종료
    @PostMapping("/sessions/{session_id}/camera/stop")
    public String stopCameraSession(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // BIO-3: 실시간 생체 스트림 (SSE)
    @GetMapping("/sessions/{session_id}/camera/stream")
    public String getBiometricStream(@PathVariable("session_id") String sessionId) {
        // TODO: Server-Sent Events(SSE)
        return "";
    }

    // BIO-4: 생체 데이터 저장
    @PostMapping("/sessions/{session_id}/biometric")
    public String createBiometricData(@PathVariable("session_id") String sessionId) {
        // TODO: rPPG 혈압·심박 + 감정 분석 결과
        return "";
    }

    // BIO-5: 생체 데이터 조회 (단일 회기)
    @GetMapping("/sessions/{session_id}/biometric")
    public String getBiometricData(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // BIO-6: 생체 데이터 기간별 조회
    @GetMapping("/clients/{client_id}/biometric")
    public String getBiometricDataByPeriod(
            @PathVariable("client_id") String clientId,
            @RequestParam("from") String from,
            @RequestParam("to") String to) {
        return "";
    }

}