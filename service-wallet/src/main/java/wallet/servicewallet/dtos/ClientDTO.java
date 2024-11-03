package wallet.servicewallet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}
