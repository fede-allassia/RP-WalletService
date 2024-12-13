package com.walletservice.controller;

import com.walletservice.model.Wallet;
import com.walletservice.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    // Endpoint to create a wallet
    @PostMapping
    public Wallet createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    // Endpoint to get the current balance
    @GetMapping("/{id}/balance")
    public Double getBalance(@PathVariable Long id) {
        return walletService.getBalance(id);
    }

    // Endpoint to deposit funds
    @PostMapping("/{id}/deposit")
    public Wallet depositFunds(@PathVariable Long id, @RequestParam Double amount) {
        return walletService.depositFunds(id, amount);
    }

    // Endpoint to withdraw funds
    @PostMapping("/{id}/withdraw")
    public Wallet withdrawFunds(@PathVariable Long id, @RequestParam Double amount) {
        return walletService.withdrawFunds(id, amount);
    }
}
