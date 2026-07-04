package com.deepcare.repository.session;

import com.deepcare.domain.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, String> {
    // 클라이언트 상세 화면(회기 이력)
    List<Session> findByClient_IdOrderByDateDesc(String clientId);

    // 담당 사회복지사의 예정 상담 일정(캘린더)
    List<Session> findByWorkerUser_IdAndDeletedFalseOrderByDateAscTimeStartAsc(String workerUserId);

    // 클라이언트별 다음 회기 번호 산정
    long countByClient_Id(String clientId);
}
