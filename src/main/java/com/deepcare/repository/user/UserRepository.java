package com.deepcare.repository.user;

import com.deepcare.domain.user.User;
import com.deepcare.domain.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    // 위험 신호 Push 수신 대상(슈퍼바이저·관리자) 조회
    List<User> findByUserTypeIn(List<UserType> userTypes);
}
