package com.model.lib;

import com.model.Member;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

class BasicTransactionDataTest {

    @Test
    void testBasicTransactionDataConstructorAndGetters() {
        Member mockMember = mock(Member.class);
        double amount = 100.0;
        int transactionDay = 15;

        BasicTransactionData transactionData = new BasicTransactionData(mockMember, amount, transactionDay);

        assertEquals(mockMember, transactionData.getMember(), "The member should match the one passed to the constructor.");
        assertEquals(amount, transactionData.getAmount(), "The amount should match the one passed to the constructor.");
        assertEquals(transactionDay, transactionData.getTransactionDay(), "The transaction day should match the one passed to the constructor.");
    }
}

