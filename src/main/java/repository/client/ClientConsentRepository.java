package repository.client;

import domain.client.ClientConsent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientConsentRepository extends JpaRepository<ClientConsent, String> {
}
