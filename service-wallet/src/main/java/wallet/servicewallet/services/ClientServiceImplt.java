package wallet.servicewallet.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.entities.Client;
import wallet.servicewallet.mapper.Mapper;
import wallet.servicewallet.repos.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImplt implements ClientService {
    private Mapper mapper;
    private ClientRepository clientRepository;

    public ClientServiceImplt(Mapper mapper, ClientRepository clientRepository) {
        this.mapper = mapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
            Client client = mapper.toClient(clientDTO);
            clientRepository.save(client);
            return mapper.toClientDTO(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOs = clients.stream().map(client -> mapper.toClientDTO(client)).collect(Collectors.toList());
        return clientDTOs;
    }

    @Override
    public ClientDTO updateClient(Long id,ClientDTO clientDTO) {
        Client client= clientRepository.findById(id).get();
        BeanUtils.copyProperties(clientDTO, client,"id");
        clientRepository.save(client);
        return mapper.toClientDTO(client);
    }


    @Override
    public ClientDTO getClient(Long clientId) {
        return mapper.toClientDTO(clientRepository.getReferenceById(clientId));
    }

    @Override
    public ClientDTO deleteClient(Long clientId) {
        Client client = clientRepository.getReferenceById(clientId);
        clientRepository.deleteById(clientId);
        return mapper.toClientDTO(client);
    }
}
