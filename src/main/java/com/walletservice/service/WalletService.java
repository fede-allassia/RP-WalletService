package com.walletservice.service;

import com.walletservice.exception.InsufficientFundsException;
import com.walletservice.exception.WalletNotFoundException;
import com.walletservice.model.Transaction;
import com.walletservice.model.Wallet;
import com.walletservice.repository.TransactionRepository;
import com.walletservice.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    // Create a new wallet
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    // Get the current balance of a wallet
    public Double getBalance(Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        return wallet.map(Wallet::getBalance).orElseThrow(() ->
                new WalletNotFoundException("Wallet with ID " + id + " not found."));
    }

    // Deposit funds into a wallet
    public Wallet depositFunds(Long id, Double amount) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet with ID " + id + " not found."));
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        // Record the transaction
        Transaction transaction = new Transaction();
        transaction.setWalletId(id);
        transaction.setType("DEPOSIT");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        return wallet;
    }

    // Withdraw funds from a wallet
    public Wallet withdrawFunds(Long id, Double amount) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet with ID " + id + " not found."));
        if (wallet.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for wallet ID " + id);
        }
        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);

        // Record the transaction
        Transaction transaction = new Transaction();
        transaction.setWalletId(id);
        transaction.setType("WITHDRAW");
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        return wallet;
    }
}
