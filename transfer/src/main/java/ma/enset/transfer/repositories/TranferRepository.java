package ma.enset.transfer.repositories;

import ma.enset.transfer.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TranferRepository extends JpaRepository<Transfer,Long> {
}
