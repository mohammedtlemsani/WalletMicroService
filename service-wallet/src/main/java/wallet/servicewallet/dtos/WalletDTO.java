package wallet.servicewallet.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor@ToString
public class WalletDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("solde")
    private Double solde;
    @JsonProperty("datecreation")
    private LocalDateTime datecreation;
    @JsonProperty("devise")
    private String devise;
    @JsonProperty("client")
    private ClientDTO client;
}
