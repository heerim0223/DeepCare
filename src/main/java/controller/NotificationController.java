package controller;

import org.springframework.web.bind.annotation.*;

// 알림
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    // N%-1: 알림 목록 조회
    @GetMapping
    public String getNotification() {
        return "";
    }

    // NT-2: 알림 읽음 처리
    @PatchMapping("/{notification_id}/read")
    public String readNotification(@PathVariable("notification_id") String notificationId) {
        return "";
    }

    // NT-3: 전체 읽음 처리
    @PatchMapping("/read-all")
    public String readAllNotification() {
        return "";
    }

    // NT-4: 위험 신호 Push 발송
    @PostMapping("/risk-alert")
    public String sendAlertRiskSignal() {
        // TODO: 슈퍼바이저 관리자 자동 수신
        return "";
    }

    // NT-5: FCM 토큰 등록
    @PostMapping("fcm-token")
    public String createFcmToken() {
        return "";
    }

}
