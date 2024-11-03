package ma.enset.transfer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
@ToString
@AllArgsConstructor@NoArgsConstructor
@Data
public class Wallet {
    @JsonProperty("id")
    private String id;
    @JsonProperty("solde")
    private double solde;
    @JsonProperty("datecreation")
    private LocalDateTime datecreation;
    @JsonProperty("devise")
    private String devise;
    @JsonProperty("client")
    private Client client;
}
