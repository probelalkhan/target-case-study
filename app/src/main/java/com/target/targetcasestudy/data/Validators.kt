package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
fun validateCreditCard(creditCardNumber: String): Boolean {
    if (creditCardNumber.isEmpty()) return false
    if (creditCardNumber.length !in (13..19)) return false

    var nSum = 0
    var isSecond = false
    for (i in creditCardNumber.length - 1 downTo 0) {
        var d = creditCardNumber[i] - '0'
        if (isSecond) d *= 2
        nSum += d / 10
        nSum += d % 10
        isSecond = !isSecond
    }
    return nSum % 10 == 0
}