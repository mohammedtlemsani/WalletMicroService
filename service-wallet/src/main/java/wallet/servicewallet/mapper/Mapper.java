package wallet.servicewallet.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.entities.Client;
import wallet.servicewallet.entities.Wallet;

@Service
public class Mapper {
    public ClientDTO toClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }
    public Client toClient(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO,client,"id");
        return client;
    }

    public WalletDTO ToWalletDTO(Wallet wallet){
        WalletDTO walletDTO=new WalletDTO();
        BeanUtils.copyProperties(wallet,walletDTO);
        walletDTO.setDatecreation(wallet.getDateCreation());
        ClientDTO clientDTO=toClientDTO(wallet.getClient());
        walletDTO.setClient(clientDTO);
        return walletDTO;
    }
    public Wallet toWallet(WalletDTO walletDTO){
        Wallet wallet=new Wallet();
        BeanUtils.copyProperties(walletDTO,wallet);
        Client client=toClient(walletDTO.getClient());
        wallet.setClient(client);
        return wallet;
    }
}
