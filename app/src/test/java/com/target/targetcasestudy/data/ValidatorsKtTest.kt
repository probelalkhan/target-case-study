package com.target.targetcasestudy.data

import org.junit.Assert.*
import org.junit.Test

class ValidatorsKtTest {

    @Test
    fun testCreditCardValidator() {
        //Valid Card Numbers
        assert(validateCreditCard("4485319050416049"))
        assert(validateCreditCard("4916922543118442"))
        assert(validateCreditCard("5394952301042573"))
        assert(validateCreditCard("345765940341201"))
        assert(validateCreditCard("6011890210162233612"))

        //Invalid Card Numbers
        assert(!validateCreditCard("44853190504169"))
        assert(!validateCreditCard("4916922548442"))
        assert(!validateCreditCard("539495230104573"))
        assert(!validateCreditCard("35765940341201"))
        assert(!validateCreditCard("601189021016223312"))
        assert(!validateCreditCard("6371947220056478"))
    }
}