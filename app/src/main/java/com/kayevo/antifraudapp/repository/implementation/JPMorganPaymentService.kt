package com.kayevo.antifraudapp.repository.implementation

import com.kayevo.antifraudapp.repository.PaymentService

class JPMorganPaymentService: PaymentService {
    override fun payWithCreditCard(paymentValue: Double, creditCardNumber: String, receiverId: String): Boolean {
        // TODO remove mock return
        return true
    }

}