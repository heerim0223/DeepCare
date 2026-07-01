package com.deepcare.repository.camera;

import com.deepcare.domain.camera.CameraMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraMetricRepository extends JpaRepository<CameraMetric, String> {
    // TODO: 대시보드(기간별 변화 추이 조회는 Service에서 세션 날짜 join 필요)
}
