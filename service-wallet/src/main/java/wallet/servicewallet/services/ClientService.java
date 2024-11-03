package wallet.servicewallet.services;

import wallet.servicewallet.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    public ClientDTO createClient(ClientDTO clientDTO);
    public List<ClientDTO> getAllClients();
    public ClientDTO updateClient(Long id,ClientDTO clientDTO);
    public ClientDTO getClient(Long clientId);
    public ClientDTO deleteClient(Long clientId);
}
