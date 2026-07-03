package com.deepcare.repository.accessLink;

import com.deepcare.domain.accessLink.AccessLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessLinkRepository extends JpaRepository<AccessLink, String> {
    Optional<AccessLink> findByClient_Id(String clientId);
}
