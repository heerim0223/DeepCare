package repository.client;

import domain.client.ClientFamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientFamilyMemberRepository extends JpaRepository<ClientFamilyMember,String> {
}
