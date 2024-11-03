package ma.enset.transfer.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.transfer.entities.Transfer;
import ma.enset.transfer.enums.TransState;
import ma.enset.transfer.model.Wallet;
import ma.enset.transfer.repositories.TranferRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {
    WalletRestClient walletRestClient;
    TranferRepository transferRepository;
    @Override
    public boolean createTransfer(Transfer transfer) {
        Wallet walletFrom =walletRestClient.findWalletById(transfer.getWalletSourceId());
        Wallet walletTo =walletRestClient.findWalletById(transfer.getWalletDestinationId());
        System.out.println(transfer.getAmount());
        if(walletFrom.getSolde()<transfer.getAmount()) return false;
        walletFrom.setSolde(walletFrom.getSolde()-transfer.getAmount());
        walletTo.setSolde(walletTo.getSolde()+transfer.getAmount());
        transfer.setState(TransState.VALIDATED);
        transfer.setDate(new Date());
        transferRepository.save(transfer);
        walletRestClient.updateWallet(transfer.getWalletSourceId(),walletFrom);
        walletRestClient.updateWallet(transfer.getWalletDestinationId(),walletTo);
        return true;
    }

    @Override
    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }
}
