package ma.enset.wallet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor@NoArgsConstructor@Builder@Getter@Setter
public class Wallet {
    @Id
    private String id;
    private double balance;
    private Date creationDate;
    private String currency;
    @OneToOne
    private Client client;

}
