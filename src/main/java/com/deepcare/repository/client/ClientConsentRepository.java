package com.deepcare.repository.client;

import com.deepcare.domain.client.ClientConsent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientConsentRepository extends JpaRepository<ClientConsent, String> {
}
