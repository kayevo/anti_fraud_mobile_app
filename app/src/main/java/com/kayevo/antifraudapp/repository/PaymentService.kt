package com.kayevo.antifraudapp.repository

interface PaymentService {
    fun payWithCreditCard(
        paymentValue: Double,
        creditCardNumber: String,
        receiverId: String
    ): Boolean
}