package com.kayevo.antifraudapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CreditCardPaymentViewModel: ViewModel() {
    private val _paymentIsFraud = MutableLiveData<Boolean>()
    val paymentIsFraud: LiveData<Boolean> get() = _paymentIsFraud
    private val _paymentAccepted = MutableLiveData<Boolean>()
    val paymentAccepted: LiveData<Boolean> get() = _paymentAccepted

    fun verifyPaymentFraud(paymentValue: Double){
        viewModelScope.launch {
            // TODO remove mock result
            _paymentIsFraud.postValue(false)
        }
    }
    
    fun pay(paymentValue: Double){
        viewModelScope.launch {
            // TODO remove mock result
            _paymentAccepted.postValue(true)
        }
    }
}