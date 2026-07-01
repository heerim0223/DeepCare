package repository.client;

import domain.client.ClientFamilyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientFamilyMemberRepository extends JpaRepository<ClientFamilyProfile,String> {
}
