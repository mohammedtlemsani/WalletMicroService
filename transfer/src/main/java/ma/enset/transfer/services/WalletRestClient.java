package ma.enset.transfer.services;

import ma.enset.transfer.model.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "service-wallet")
public interface WalletRestClient {

    @GetMapping("/wallets")
    List<Wallet> findAllWallets();

    @GetMapping("/wallets/{id}")
    Wallet findWalletById(@PathVariable("id") String id);

    @PutMapping("/wallets/{id}")
    Wallet updateWallet(@PathVariable("id") String id, @RequestBody Wallet wallet);
}
