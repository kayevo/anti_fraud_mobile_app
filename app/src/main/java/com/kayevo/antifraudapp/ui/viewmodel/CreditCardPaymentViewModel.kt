package com.kayevo.antifraudapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kayevo.antifraudapp.repository.PaymentService
import com.kayevo.antifraudapp.repository.FraudDetectionService
import kotlinx.coroutines.launch

class CreditCardPaymentViewModel(
    val fraudDetectionService: FraudDetectionService,
    val paymentService: PaymentService
) : ViewModel() {
    private val _paymentIsFraud = MutableLiveData<Boolean>()
    val paymentIsFraud: LiveData<Boolean> get() = _paymentIsFraud
    private val _paymentAccepted = MutableLiveData<Boolean>()
    val paymentAccepted: LiveData<Boolean> get() = _paymentAccepted

    fun verifyPaymentFraud(
        paymentValue: Double,
        payerCountry: String,
        creditCardNumber: Long,
        payerId: String,
        receiverId: String,
        receiverCountry: String
    ) {
        viewModelScope.launch {
            val isFraud = fraudDetectionService.verifyPaymentFraud(
                paymentValue = paymentValue,
                payerCountry = payerCountry,
                creditCardNumber = creditCardNumber,
                payerId = payerId,
                receiverId = receiverId,
                receiverCountry = receiverCountry,
            )
            _paymentIsFraud.postValue(isFraud)
        }
    }

    fun pay(
        paymentValue: Double,
        creditCardNumber: String,
        receiverId: String
    ) {
        viewModelScope.launch {
            val isPaymentAccepted = paymentService.payWithCreditCard(
                paymentValue=paymentValue,
                creditCardNumber=creditCardNumber,
                receiverId=receiverId,
            )
            _paymentAccepted.postValue(isPaymentAccepted)
        }
    }
}