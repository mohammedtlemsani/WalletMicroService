package ma.enset.transfer;

import ma.enset.transfer.services.TransferService;
import ma.enset.transfer.services.WalletRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class TransferApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransferApplication.class, args);
	}

	//@Bean
	/*CommandLineRunner start(WalletRestClient walletRestClient, TransferService transferService) {
		return args -> {
			System.out.println("List of wallets");
			walletRestClient.findAllWallets().forEach(w -> {
				System.out.println(w);
			});
			if(transferService.createTransfer("4cff9987-6f85-4bc3-acd7-f6052433f789", "d7365454-7510-46e8-a0cc-7a310d1c05f4", 100)){
				System.out.println("Transfer done successfully");
			}
		};
	}*/
}
