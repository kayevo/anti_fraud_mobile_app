package com.kayevo.antifraudapp.repository

interface FraudDetectionService {
    fun verifyPaymentFraud(
        paymentValue: Double,
        payerCountry: String,
        creditCardNumber: Long,
        payerId: String,
        receiverId: String,
        receiverCountry: String
    ): Boolean
}