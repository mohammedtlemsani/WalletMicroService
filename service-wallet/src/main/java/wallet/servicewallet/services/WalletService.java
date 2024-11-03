package wallet.servicewallet.services;

import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.entities.Wallet;

import java.util.List;

public interface WalletService {
    public WalletDTO createWallet(WalletDTO walletDTO);
    public WalletDTO getWalletById(String walletId);
    public List<WalletDTO> getAllWallets();
    public WalletDTO updateWallet(String walletId,WalletDTO walletDTO);
    public WalletDTO getWalletId(Long id);
    public void deleteWallet(String walletId);
}
