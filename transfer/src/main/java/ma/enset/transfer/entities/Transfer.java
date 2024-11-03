package ma.enset.transfer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.enset.transfer.enums.TransState;
import ma.enset.transfer.model.Wallet;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@ToString
public class Transfer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String walletSourceId;
    private String walletDestinationId;
    @Transient
    private Wallet walletSource;
    @Transient
    private Wallet walletDestination;
    private Double amount;
    private TransState state;
}
