package wallet.servicewallet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.services.WalletService;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public WalletDTO createWallet(@RequestBody WalletDTO walletDTO) {
        System.out.println("walletDTO = " + walletDTO);
        return walletService.createWallet(walletDTO);
    }

    @GetMapping("/")
    public List<WalletDTO> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{id}")
    public WalletDTO getWallet(@PathVariable String id) {
        return walletService.getWalletById(id);
    }

    @PutMapping("/{id}")
    public WalletDTO updateWallet(@PathVariable String id, @RequestBody WalletDTO walletDTO) {
        System.out.println("walletDTO = " + walletDTO);
        return walletService.updateWallet(id, walletDTO);
    }

   // @GetMapping("/walletClient/{id}")
    public WalletDTO getWalletId(@PathVariable Long id) {
        return walletService.getWalletId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable String id) {
        walletService.deleteWallet(id);
    }
}
