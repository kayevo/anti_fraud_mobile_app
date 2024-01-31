package com.kayevo.antifraudapp.repository.implementation

import com.kayevo.antifraudapp.repository.FraudDetectionService

class FeedzaiFraudDetectionService: FraudDetectionService {
    override fun verifyPaymentFraud(
        paymentValue: Double,
        payerCountry: String,
        creditCardNumber: Long,
        payerId: String,
        receiverId: String,
        receiverCountry: String
    ): Boolean {
        // TODO remove mock return
        return false
    }

}