package wallet.servicewallet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.entities.Client;
import wallet.servicewallet.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,String> {
    public Wallet getWalletByClientId(Long clientId);
}
