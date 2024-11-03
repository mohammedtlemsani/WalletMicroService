package wallet.servicewallet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import wallet.servicewallet.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
