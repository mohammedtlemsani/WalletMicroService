package ma.enset.transfer.controllers;

import lombok.AllArgsConstructor;
import ma.enset.transfer.entities.Transfer;
import ma.enset.transfer.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransferController {
    TransferService transferService;
    @PostMapping("/createTransfer")
    public boolean createTransfer(@RequestBody Transfer transfer){
        System.out.println(transfer);
        return transferService.createTransfer(transfer);
    }
    @GetMapping("/transfers")
    public List<Transfer> getAllTransfers(){
        return transferService.getAllTransfers();
    }
}
