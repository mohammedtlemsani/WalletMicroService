package ma.enset.wallet;

import ma.enset.wallet.repositories.ClientRepository;
import ma.enset.wallet.repositories.WalletRepository;
import ma.enset.wallet.entities.Client;
import ma.enset.wallet.entities.Wallet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class WalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, WalletRepository walletRepository) {
        return args -> {
            Stream.of("hamid", "yahya", "youssef").forEach(c -> {
                clientRepository.save(Client.builder().name(c).email(c + "@gmail.com").build());
            });
            Stream.of("hamid", "yahya", "youssef").forEach(c -> {
                walletRepository.save(Wallet.builder().id(UUID.randomUUID().toString()).balance(1000).currency("MAD").client(clientRepository.findClientByName(c)).build());
            });
        };
    }
}
