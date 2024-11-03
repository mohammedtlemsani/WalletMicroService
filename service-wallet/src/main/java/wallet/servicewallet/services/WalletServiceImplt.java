package wallet.servicewallet.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.entities.Wallet;
import wallet.servicewallet.mapper.Mapper;
import wallet.servicewallet.repos.WalletRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletServiceImplt implements WalletService{

    private WalletRepository walletRepository;
    private Mapper mapper;

    public WalletServiceImplt(WalletRepository walletRepository,
                              Mapper mapper) {
        this.walletRepository = walletRepository;
        this.mapper=mapper;
    }

    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
        Wallet wallet=mapper.toWallet(walletDTO);
        walletRepository.save(wallet);
        return mapper.ToWalletDTO(wallet);
    }

    @Override
    public WalletDTO getWalletById(String walletId) {
        Wallet wallet=walletRepository.findById(walletId).get();
        return mapper.ToWalletDTO(wallet);
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        List<Wallet> wallets=walletRepository.findAll();
        List<WalletDTO> walletDTOS=wallets.stream().map(wallet -> mapper.ToWalletDTO(wallet)).collect(Collectors.toList());
        return walletDTOS;
    }

    @Override
    public WalletDTO updateWallet(String walletId,WalletDTO walletDTO) {
        Wallet wallet=walletRepository.findById(walletId).get();
        BeanUtils.copyProperties(walletDTO,wallet,"id");
        walletRepository.save(wallet);
        return mapper.ToWalletDTO(wallet);
    }

    @Override
    public WalletDTO getWalletId(Long id) {
        return mapper.ToWalletDTO(walletRepository.getWalletByClientId(id));
    }

    @Override
    public void deleteWallet(String walletId) {
        walletRepository.deleteById(walletId);
    }
}
