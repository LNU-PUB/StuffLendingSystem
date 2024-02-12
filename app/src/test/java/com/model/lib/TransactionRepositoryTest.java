package com.model.lib;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.model.Member;
import com.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class TransactionRepositoryTest {

    private TransactionRepository repository;
    private Member member;
    private Transaction transaction;
    private BasicTransactionData transactionData;

    @BeforeEach
    void setUp() {
        repository = new TransactionRepository(List.of());

        member = mock(Member.class);
        transaction = mock(Transaction.class);
        transactionData = new BasicTransactionData(member, 100.0, 10);

        when(transaction.getMember()).thenReturn(member);
        when(transaction.getAmount()).thenReturn(100.0);
        when(transaction.getTransactionDay()).thenReturn(10);
        when(transaction.getId()).thenReturn("transId");
    }

    @Test
    void getAllTransactions_ReturnsEmptyList_Initially() {
        assertTrue(((List<Transaction>) repository.getAllTransactions()).isEmpty(), "Initially, transactions list should be empty.");
    }

    @Test
    void addNewTransaction_AddsTransactionSuccessfully() {
        Transaction added = repository.addNewTransaction(transactionData);

        assertNotNull(added, "The added transaction should not be null.");
        assertEquals(1, ((List<Transaction>) repository.getAllTransactions()).size(), "Repository should contain one transaction after adding.");
    }

    @Test
    void getTransactionById_ReturnsCorrectTransaction() {
        Transaction added = repository.addNewTransaction(transactionData);
        
        Transaction found = repository.getTransactionById(added.getId());
        
        assertNotNull(found, "Should return a transaction for a valid ID.");
        assertEquals(added.getId(), found.getId(), "The found transaction should have the same ID as the added one.");
    }

    @Test
    void getTransactionsByMember_ReturnsCorrectTransactions() {
        repository.addNewTransaction(transactionData);

        Iterable<Transaction> transactions = repository.getTransactionsByMember(member);

        assertEquals(1, ((List<Transaction>) transactions).size(), "Should return transactions for the specified member.");
    }

    @Test
    void testDeleteTransactionSuccess() {
        Transaction added = repository.addNewTransaction(transactionData);

        boolean result = repository.deleteTransaction(added);

        assertTrue(result, "Should return true when a transaction is successfully deleted.");
        assertTrue(((List<Transaction>) repository.getAllTransactions()).isEmpty(), "Transactions list should be empty after deletion.");
    }

    @Test
    void testDeleteTransactionFailure() {
        Transaction added = repository.addNewTransaction(transactionData);
        Transaction fail = new Transaction("fail", member, 100.0, 10);

        boolean result = repository.deleteTransaction(fail);

        assertFalse(result, "Should return true when a transaction is successfully deleted.");
        assertTrue(((List<Transaction>) repository.getAllTransactions()).size() == 1, "Transactions list should contain one transaction after failed deletion.");
    }

    @Test
    void updateTransaction_UpdatesTransactionSuccessfully() {
        Transaction added = repository.addNewTransaction(transactionData);
        BasicTransactionData updatedData = new BasicTransactionData(member, 200.0, 20);
        Transaction updatedTransaction = new Transaction(added.getId(), updatedData.getMember(), updatedData.getAmount(), updatedData.getTransactionDay());

        Transaction updated = repository.updateTransaction(updatedTransaction, added);

        assertNotNull(updated, "Update should return a non-null transaction.");
        assertEquals(200.0, updated.getAmount(), "Amount should be updated to 200.0.");
        assertEquals(20, updated.getTransactionDay(), "Transaction day should be updated to 20.");
    }

    @Test
    void getMemberBalance_CalculatesBalanceCorrectly() {
        repository.addNewTransaction(transactionData);
        repository.addNewTransaction(new BasicTransactionData(member, 12.0, 15));
        repository.addNewTransaction(new BasicTransactionData(member, 50.09, 15));
        repository.addNewTransaction(new BasicTransactionData(member, -16.0, 15));
        repository.addNewTransaction(new BasicTransactionData(member, -10.23, 15));

        double balance = repository.getMemberBalance(member);

        assertEquals(135.86, balance, "Balance should be the sum of all transactions for the member.");
    }
}

