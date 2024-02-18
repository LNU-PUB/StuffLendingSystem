package com.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class TransactionTest {

    @Test
    void testTransactionConstructorWithParameters() {
        String expectedId = "trans123";
        Member expectedMember = mock(Member.class);
        double expectedAmount = 100.0;
        int expectedTransactionDay = 10;

        Transaction transaction = new Transaction(expectedId, expectedMember, expectedAmount, expectedTransactionDay);

        assertEquals(expectedId, transaction.getId(), "ID should match the one provided to the constructor.");
        assertEquals(expectedMember, transaction.getMember(), "Member should match the one provided to the constructor.");
        assertEquals(expectedAmount, transaction.getAmount(), "Amount should match the one provided to the constructor.");
        assertEquals(expectedTransactionDay, transaction.getTransactionDay(), "Transaction day should match the one provided to the constructor.");
    }

    @Test
    void testTransactionCopyConstructor() {
        String originalId = "trans456";
        Member originalMember = mock(Member.class);
        double originalAmount = 200.0;
        int originalTransactionDay = 20;
        Transaction originalTransaction = new Transaction(originalId, originalMember, originalAmount, originalTransactionDay);

        Transaction copiedTransaction = new Transaction(originalTransaction);

        assertEquals(originalTransaction.getId(), copiedTransaction.getId(), "Copied transaction ID should match original.");
        assertEquals(originalTransaction.getMember(), copiedTransaction.getMember(), "Copied transaction member should match original.");
        assertEquals(originalTransaction.getAmount(), copiedTransaction.getAmount(), "Copied transaction amount should match original.");
        assertEquals(originalTransaction.getTransactionDay(), copiedTransaction.getTransactionDay(), "Copied transaction day should match original.");
    }
}
