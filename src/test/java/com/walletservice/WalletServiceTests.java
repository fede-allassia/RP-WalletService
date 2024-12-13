/*
package com.walletservice;

import com.walletservice.exception.InsufficientFundsException;
import com.walletservice.exception.WalletNotFoundException;
import com.walletservice.model.Wallet;
import com.walletservice.repository.TransactionRepository;
import com.walletservice.repository.WalletRepository;
import com.walletservice.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WalletServiceTests {

    private WalletRepository walletRepository;
    private TransactionRepository transactionRepository;
    private WalletService walletService;

    @BeforeEach
    void setUp() {
        walletRepository = Mockito.mock(WalletRepository.class);
        transactionRepository = Mockito.mock(TransactionRepository.class);
        walletService = new WalletService(walletRepository, transactionRepository);
    }

    @Test
    void testCreateWallet() {
        Wallet wallet = new Wallet();
        wallet.setUserId("user123");

        when(walletRepository.save(any(Wallet.class))).thenReturn(wallet);

        Wallet createdWallet = walletService.createWallet(wallet);

        assertNotNull(createdWallet);
        assertEquals("user123", createdWallet.getUserId());
        verify(walletRepository, times(1)).save(wallet);
    }

    @Test
    void testGetBalance() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setBalance(100.0);

        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));

        Double balance = walletService.getBalance(1L);

        assertEquals(100.0, balance);
    }

    @Test
    void testGetBalanceWalletNotFound() {
        when(walletRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(WalletNotFoundException.class, () -> walletService.getBalance(1L));
    }

    @Test
    void testDepositFunds() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setBalance(100.0);

        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));
        when(walletRepository.save(any(Wallet.class))).thenReturn(wallet);

        Wallet updatedWallet = walletService.depositFunds(1L, 50.0);

        assertEquals(150.0, updatedWallet.getBalance());
    }

    @Test
    void testWithdrawFunds() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setBalance(100.0);

        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));
        when(walletRepository.save(any(Wallet.class))).thenReturn(wallet);

        Wallet updatedWallet = walletService.withdrawFunds(1L, 50.0);

        assertEquals(50.0, updatedWallet.getBalance());
    }

    @Test
    void testWithdrawFundsInsufficientBalance() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setBalance(30.0);

        when(walletRepository.findById(1L)).thenReturn(Optional.of(wallet));

        assertThrows(InsufficientFundsException.class, () -> walletService.withdrawFunds(1L, 50.0));
    }
}
*/