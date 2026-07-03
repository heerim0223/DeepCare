package com.deepcare.repository.client;

import com.deepcare.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    // primary_worker 기준 담당 클라이언트 목록 (케이스 목록 화면용)
    List<Client> findByPrimaryWorker_Id(String workerUserId);

    List<Client> findByNameContainingOrContactPhoneContaining(
            String name,
            String contactPhone
    );
}