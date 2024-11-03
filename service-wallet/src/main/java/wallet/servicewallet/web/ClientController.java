package wallet.servicewallet.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wallet.servicewallet.dtos.ClientDTO;
import wallet.servicewallet.dtos.WalletDTO;
import wallet.servicewallet.services.ClientService;
import java.util.List;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long  id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO ClientDTO) {
        return clientService.updateClient(id,ClientDTO);
    }

    @GetMapping("/Client/{id}")
    public ClientDTO getClientId(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }
}
