package repository.visibility;

import domain.visibility.FieldVisibility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldVisibilityRepository extends JpaRepository<FieldVisibility, String> {
    // 클라이언트 공개 항목 필터링에 사용될 쿼리
    List<FieldVisibility> findByClient_Id(String clientId);
}
