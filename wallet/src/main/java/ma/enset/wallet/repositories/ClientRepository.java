package ma.enset.wallet.repositories;


import ma.enset.wallet.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByName(String name);
}
