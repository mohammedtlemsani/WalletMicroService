package ma.enset.transfer.services;

import ma.enset.transfer.entities.Transfer;

import java.util.List;

public interface TransferService {
    public boolean createTransfer(Transfer transfer);
    public List<Transfer> getAllTransfers();
    }
