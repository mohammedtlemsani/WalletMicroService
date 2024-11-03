package wallet.servicewallet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import wallet.servicewallet.entities.Client;
import wallet.servicewallet.entities.Wallet;
import wallet.servicewallet.repos.ClientRepository;
import wallet.servicewallet.repos.WalletRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@SpringBootApplication
public class ServiceWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceWalletApplication.class, args);
    }
    //@Bean
    CommandLineRunner start(ClientRepository clientRepository, WalletRepository walletRepository) {
        return args -> {
            Stream.of("Client1", "Client2", "Client3").forEach(c -> {
                Client client = new Client();
                client.setNom(c);
                client.setEmail(c + "@gmail.com");
                clientRepository.save(client);
            });
            AtomicInteger i = new AtomicInteger();
            Stream.of("Wallet1", "Wallet2", "Wallet3").forEach(w -> {
                Wallet wallet = new Wallet();
                wallet.setId(UUID.randomUUID().toString());
                wallet.setSolde(1000D);
                wallet.setDateCreation(LocalDateTime.now());
                wallet.setClient(clientRepository.findAll().get(i.getAndIncrement()));
                walletRepository.save(wallet);
            });
        };
    }
}